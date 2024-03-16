package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static BinaryTree<String, String> processDictionaryFile(String fileName) throws IOException {
        BinaryTree<String, String> dictionaryTree = null;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim().substring(1, line.length() - 1);
            String[] parts = line.split(", ");
            String english = parts[0].toLowerCase();
            String spanish = parts[1];
            if (dictionaryTree == null) {
                dictionaryTree = new BinaryTree<>(english, spanish);
            } else {
                dictionaryTree.insert(english, spanish);
            }
        }
        reader.close();
        return dictionaryTree;
    }

    public static String translateText(BinaryTree<String, String> dictionaryTree, String fileName) throws IOException {
        StringBuilder translatedText = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                word = word.toLowerCase();
                String translation = dictionaryTree.search(word);
                if (translation != null) {
                    translatedText.append(translation).append(" ");
                } else {
                    translatedText.append("*").append(word).append("* ").append(" ");
                }
            }
            translatedText.append("\n");
        }
        reader.close();
        return translatedText.toString();
    }

    public static void main(String[] args) {
        try {
            // Procesar archivo de diccionario
            BinaryTree<String, String> dictionaryTree = processDictionaryFile("diccionario.txt");

            // Recorrer árbol en orden
            System.out.println("Diccionario ordenado por inglés:");
            dictionaryTree.inorderTraversal();

            // Traducir texto
            String translatedText = translateText(dictionaryTree, "texto.txt");
            System.out.println("\nTexto traducido:");
            System.out.println(translatedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
