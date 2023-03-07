package org.lionheart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class FindOneShipwreck {

    public static void main(String[] args){

        String mongoUri = "mongodb+srv://root:<password>@cluster0.antyn.mongodb.net/?retryWrites=true&w=majority";

        try(MongoClient mongoClient = MongoClients.create(mongoUri)){
            MongoDatabase database = mongoClient.getDatabase("sample_geospatial");
            MongoCollection<Document> collection =  database.getCollection("shipwrecks");


            Document doc = collection.find();
        }
    }
}