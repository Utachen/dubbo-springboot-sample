package com.example.service.impl;


import io.netty.util.internal.StringUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JavaReadFile {

    //    public static void main(String[] args) throws IOException {
//        String fileName = "C:\\Users\\FM\\company.txt";
//
//        //使用Java 7中的Files类处理小文件，获取完整的文件数据
//        readUsingFiles(fileName);
//
//        //使用Scanner类来处理大文件，逐行读取
//        readUsingScanner(fileName);
//
//        //使用BufferedReader读取，逐行读取
//        readUsingBufferedReader(fileName);
//        readUsingBufferedReaderJava7(fileName, StandardCharsets.UTF_8);
//        readUsingBufferedReader(fileName, StandardCharsets.UTF_8);
//
//        //使用FileReader读取，没有编码支持，效率不高
//        readUsingFileReader(fileName);
//    }
    private static final String pattern = "![\\u4E00-\\u9FA5]";
    private static final Pattern PATTERN = Pattern.compile(pattern);
    private static final LinkedHashSet<String> linkedhashSet = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        String fileName = "D:\\butterfly\\work\\工作文件\\2022年6月\\影刀\\company.txt";
        String storeFileName = "D:\\butterfly\\work\\工作文件\\2022年6月\\影刀\\companyStore.txt";
        readUsingBufferedReader(fileName);
        linkedhashSet.forEach(System.out::println);
        System.out.println(linkedhashSet.size());

    }



    private static void readUsingBufferedReader(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        System.out.println("Read text file using BufferedReader");
        while((line = br.readLine()) != null){
            //逐行读取
            linkedhashSet.addAll(Arrays.stream(line.split(",")).map(s -> s.replaceAll("[a-zA-Z0-9\\-\\[\\]\\.\\:]", "")).filter(s -> !StringUtil.isNullOrEmpty(s)).collect(Collectors.toList()));
        }
        //close resources
        br.close();
        fr.close();
    }

    private static void readUsingFileReader(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        System.out.println("Reading text file using FileReader");
        while((line = br.readLine()) != null){
            //逐行读取
            System.out.println(line);
        }
        br.close();
        fr.close();

    }

    private static void readUsingBufferedReader(String fileName, Charset cs) throws IOException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, cs);
        BufferedReader br = new BufferedReader(isr);
        String line;
        System.out.println("Read text file using InputStreamReader");
        while((line = br.readLine()) != null){
            //逐行读取
            System.out.println(line);
        }
        br.close();

    }

    private static void readUsingBufferedReaderJava7(String fileName, Charset cs) throws IOException {
        Path path = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(path, cs);
        String line;
        System.out.println("Read text file using BufferedReader Java 7 improvement");
        while((line = br.readLine()) != null){
            //逐行读取
            System.out.println(line);
        }
        br.close();
    }


    private static void readUsingScanner(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        System.out.println("Read text file using Scanner");
        //逐行读取
        while(scanner.hasNextLine()){
            //逐行处理
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }

    private static void readUsingFiles(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        //将文件读取到字节数组
        byte[] bytes = Files.readAllBytes(path);
        System.out.println("Read text file using Files class");
        //read file to String list
        @SuppressWarnings("unused")
        List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println(new String(bytes));
    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java/java-read-text-file.html

