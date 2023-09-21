package org.example;

import javax.servlet.annotation.WebServlet;

import static spark.Spark.*;

public class SparkWebServer{

    public static void main(String... args){
        port(getPort());
        // Habilitar CORS para todas las rutas
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        // Configurar los encabezados CORS para permitir solicitudes desde cualquier origen
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Request-Method", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "*");
        });
        get("/home", (req, res) -> {
            return WebPage.getWebPage();
        });
        get("hello", (req,res) -> "Hello Docker!");
        get("/sin/:valor", (req, res) -> {
          double valor = Double.parseDouble(req.params("valor"));
          double result = Math.sin(valor);
          return result;
        });
        get("/cos/:valor", (req, res) -> {
            double valor = Double.parseDouble(req.params("valor"));
            double result = Math.cos(valor);
            return result;
        });
        get("/palindromo/:cadena", (req, res) -> {
            String invertida = new StringBuilder(req.params("cadena")).reverse().toString();
            return req.params("cadena").equals(invertida);
        });
        get("/vector/:p1/:p2", (req, res) -> {
            Double p1 = Double.parseDouble(req.params("p1"));
            Double p2 = Double.parseDouble(req.params("p2"));
            return Math.sqrt(Math.pow(p1, 2)+Math.pow(p2, 2));
        });
    }

    private static double calSin(double valor){
        return Math.sin(valor);
    }
    private static double calCos(double valor) {
        return Math.cos(valor);
    }
    private static Boolean calPalindromo(String cadena){
        String invertida = new StringBuilder(cadena).reverse().toString();
        return cadena.equals(invertida);
    }

    private static double calVector (double p1, double p2){
        return Math.sqrt(Math.pow(p1, 2)+Math.pow(p2, 2));
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}