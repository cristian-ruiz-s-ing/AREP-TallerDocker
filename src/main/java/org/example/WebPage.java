package org.example;

public class WebPage {
    public static String getWebPage(){
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Calculadora de Seno</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Funciones bono:</h1>\n" +
                "<p>Seno: </p>\n" +
                "<input type=\"number\" id=\"valorSin\" placeholder=\"Ingrese un valor\">\n" +
                "<button onclick=\"calcularSin()\">Calcular</button>\n" +
                "<p id=\"resultSin\"></p>\n" +
                "\n" +
                "<p>Coseno: </p>\n" +
                "<input type=\"number\" id=\"valorCos\" placeholder=\"Ingrese un valor\">\n" +
                "<button onclick=\"calcularCos()\">Calcular</button>\n" +
                "<p id=\"resultCos\"></p>\n" +
                "\n" +
                "<p>Palindromo: </p>\n" +
                "<input type=\"text\" id=\"valorCadena\" placeholder=\"Ingrese una palabra\">\n" +
                "<button onclick=\"palindromo()\">Calcular</button>\n" +
                "<p id=\"resultPalin\"></p>\n" +
                "\n" +
                "<p>Magnitud de un vector: </p>\n" +
                "<input type=\"number\" id=\"valorVector1\" placeholder=\"Ingrese el primer valor\">\n" +
                "<input type=\"number\" id=\"valorVector2\" placeholder=\"Ingrese el segundo valor\">\n" +
                "<button onclick=\"calcularVec()\">Calcular</button>\n" +
                "<p id=\"resultVec\"></p>\n" +
                "\n" +
                "<script>\n" +
                "        function calcularCos() {\n" +
                "            const valor = document.getElementById(\"valorCos\").value;\n" +
                "\n" +
                "            fetch(`http://localhost:4567/cos/${valor}`, {\n" +
                "                method: 'GET',\n" +
                "                mode: 'no-cors'\n" +
                "                })\n" +
                "                .then(response => response.json())\n" +
                "                .then(data => {\n" +
                "                    document.getElementById(\"resultCos\").textContent = `${data}`;\n" +
                "                })\n" +
                "                .catch(error => {\n" +
                "                    console.error('Error:', error);\n" +
                "                });\n" +
                "        }\n" +
                "\n" +
                "        function calcularSin() {\n" +
                "            const valor = document.getElementById(\"valorSin\").value;\n" +
                "            fetch(`http://localhost:4567/sin/${valor}`, {\n" +
                "                method: 'GET',\n" +
                "                mode: 'no-cors'\n" +
                "                })\n" +
                "                .then(response => response.json())\n" +
                "                .then(data => {\n" +
                "                    document.getElementById(\"resultSin\").textContent = `${data}`;\n" +
                "                })\n" +
                "                .catch(error => {\n" +
                "                    console.error('Error:', error);\n" +
                "                });\n" +
                "        }\n" +
                "\n" +
                "        function palindromo() {\n" +
                "            const valor = document.getElementById(\"valorCadena\").value;\n" +
                "            fetch(`http://localhost:4567/palindromo/${valor}`, {\n" +
                "                method: 'GET',\n" +
                "                mode: 'no-cors'\n" +
                "                })\n" +
                "                .then(response => response.json())\n" +
                "                .then(data => {\n" +
                "                    document.getElementById(\"resultPalin\").textContent = `${data}`;\n" +
                "                })\n" +
                "                .catch(error => {\n" +
                "                    console.error('Error:', error);\n" +
                "                });\n" +
                "        }\n" +
                "\n" +
                "        function calcularVec() {\n" +
                "            const valor1 = document.getElementById(\"valorVector1\").value;\n" +
                "            const valor2 = document.getElementById(\"valorVector2\").value;\n" +
                "\n" +
                "            fetch(`http://localhost:4567/vector/${valor1}/${valor2}`, {\n" +
                "                method: 'GET',\n" +
                "                mode: 'no-cors'\n" +
                "                })\n" +
                "                .then(response => response.json())\n" +
                "                .then(data => {\n" +
                "                    document.getElementById(\"resultVec\").textContent = `${data}`;\n" +
                "                })\n" +
                "                .catch(error => {\n" +
                "                    console.error('Error:', error);\n" +
                "                });\n" +
                "        }\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>";
        return html;
    }
}
