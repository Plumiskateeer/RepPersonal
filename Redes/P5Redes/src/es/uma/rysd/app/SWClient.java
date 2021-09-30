package es.uma.rysd.app;

import javax.net.ssl.HttpsURLConnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.google.gson.Gson;

import es.uma.rysd.entities.*;

public class SWClient {
	// TODO: Complete el nombre de la aplicación
    private final String app_name = "";
    private final int year = 2021;
    
    private final String url_api = "https://swapi.dev/api/";

    // Métodos auxiliares facilitados
    
    // Obtiene la URL del recurso id del tipo resource
	public String generateEndpoint(String resource, Integer id){
		return url_api + resource + "/" + id + "/";
	}
	
	// Dada una URL de un recurso obtiene su ID
	public Integer getIDFromURL(String url){
		String[] parts = url.split("/");

		return Integer.parseInt(parts[parts.length-1]);
	}
	
	// Consulta un recurso y devuelve cuántos elementos tiene
	public int getNumberOfResources(String resource){
		// TODO: Trate de forma adecuada las posibles excepciones que pueden producirse
		int count = 0;
			// TODO: Cree la URL correspondiente: https://swapi.dev/api/{recurso}/ reemplazando el recurso por el parámetro
			try {
				URL url = new URL(url_api + URLEncoder.encode(resource, "utf-8"));

				// TODO: Cree la conexión a partir de la URL
				HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

				// TODO: Añada las cabeceras User-Agent y Accept (vea el enunciado)
				connection.setRequestProperty("User-Agent", app_name + "-" + year);
				connection.setRequestProperty("Accept", "application/json");
				// TODO: Indique que es una petición GET

				connection.setRequestMethod("GET");

				// TODO: Compruebe que el código recibido en la respuesta es correcto

				if (!(connection.getResponseCode() < 199) && !(connection.getResponseCode() > 301)) {

					// TODO: Obtenga el InputStream de la conexión
					Gson parser = new Gson();
					InputStream in = connection.getInputStream();
					ResourceCountResponse c = parser.fromJson(new InputStreamReader(in), ResourceCountResponse.class);
					// TODO: Devuelva el número de elementos

					// TODO: Deserialice la respuesta a ResourceCountResponse
					if(c!=null)
					count = c.count;

				} else {
					System.out.println("Codigo de respuesta incorrecto (" + connection.getResponseCode() + ")");
				}
			} catch (ProtocolException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return count;
		}


	public Person getPerson(String urlname) {
    	Person p = null;
    	// Por si acaso viene como http la pasamos a https
    	urlname = urlname.replaceAll("http:", "https:");

    	// TODO: Trate de forma adecuada las posibles excepciones que pueden producirse
		HttpsURLConnection connection = null;
		URL url = null;
		try {

			// TODO: Cree la conexión a partir de la URL recibida
			 url = new URL(urlname);
			connection = (HttpsURLConnection) url.openConnection();
			// TODO: Añada las cabeceras User-Agent y Accept (vea el enunciado)
			connection.setRequestProperty("User-Agent", app_name);
			connection.setRequestProperty("Accept", "application/json");
			// TODO: Indique que es una petición GET
			connection.setRequestMethod("GET");

			// TODO: Compruebe que el código recibido en la respuesta es correcto
			if (!(connection.getResponseCode() < 199) && !(connection.getResponseCode() > 301)) {
				// TODO: Deserialice la respuesta a Person
				Gson parser = new Gson();
				InputStream in = connection.getInputStream();
				Person searched = parser.fromJson(new InputStreamReader(in), Person.class);
				// TODO: Para las preguntas 2 y 3 (no necesita completar esto para la pregunta 1)
				// TODO: A partir de la URL en el campo homreworld obtenga los datos del planeta y almacénelo en atributo homeplanet
				Planet plt = getPlanet(searched.homeworld);
				searched.homeplanet = plt;

				p = searched;
			}else{
				System.out.println("Codigo de respuesta incorrecto (" + connection.getResponseCode() + ")");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return p;
	}

	public Planet getPlanet(String urlname) {
    	Planet p = null;
    	// Por si acaso viene como http la pasamos a https
    	urlname = urlname.replaceAll("http:", "https:");

    	// TODO: Trate de forma adecuada las posibles excepciones que pueden producirse
		HttpsURLConnection connection = null;
		try {
    	// TODO: Cree la conexión a partir de la URL recibida
			URL url = new URL(urlname);
			connection = (HttpsURLConnection) url.openConnection();
    	// TODO: Añada las cabeceras User-Agent y Accept (vea el enunciado)
			connection.setRequestProperty("User-Agent", app_name);
			connection.setRequestProperty("Accept", "application/json");
			// TODO: Indique que es una petición GET
			connection.setRequestMethod("GET");

    	// TODO: Compruebe que el código recibido en la respuesta es correcto
			if (!(connection.getResponseCode() < 199) && !(connection.getResponseCode() > 301)) {

				// TODO: Deserialice la respuesta a Planet
				Gson parser = new Gson();
				InputStream in = connection.getInputStream();
				p = parser.fromJson(new InputStreamReader(in), Planet.class);
			}else{
				System.out.println("Codigo de respuesta incorrecto (" + connection.getResponseCode() + ")");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return p;
	}

	public Person search(String name){
    	Person p = null;
    	// TODO: Trate de forma adecuada las posibles excepciones que pueden producirse
		  try {
			  // TODO: Cree la conexión a partir de la URL (url_api + name tratado - vea el enunciado)
			  URL url = new URL(url_api + URLEncoder.encode(name, "utf-8"));
			  HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			  // TODO: Añada las cabeceras User-Agent y Accept (vea el enunciado)
			  connection.setRequestProperty("User-Agent", app_name  + "-" + year);
			  connection.setRequestProperty("Accept", "application/json");

			  // TODO: Indique que es una petición GET
			  connection.setRequestMethod("GET");

			  // TODO: Compruebe que el código recibido en la respuesta es correcto
			  if(!(connection.getResponseCode() < 199) && !(connection.getResponseCode() > 301)) {
				  // TODO: Deserialice la respuesta a SearchResponse -> Use la primera posici?n del array como resultado
				  Gson parser = new Gson();
				  InputStream in = connection.getInputStream(); // TODO: Obtenga el InputStream de la conexi?n
				  SearchResponse searched = parser.fromJson(new InputStreamReader(in), SearchResponse.class);

				  // TODO: Para las preguntas 2 y 3 (no necesita completar esto para la pregunta 1)
				  // TODO: A partir de la URL en el campo homreworld obtenga los datos del planeta y almac?nelo en atributo homeplanet

				  if(searched.results.length != 0) {

					  Planet plt = getPlanet(searched.results[0].homeworld);
					  searched.results[0].homeplanet = plt;

					  p = searched.results[0];
				  }
			  }
		  } catch (MalformedURLException e) {
			  e.printStackTrace();
		  } catch (UnsupportedEncodingException e) {
			  e.printStackTrace();
		  } catch (IOException e) {
			  e.printStackTrace();
		  }

        return p;
    }

}
