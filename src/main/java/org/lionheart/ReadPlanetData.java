package org.lionheart;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import org.bson.conversions.Bson;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
/*
* What I learned?
* I retrieved the entire collection of planets from Atlas,
* Store the search in a FindIterable
* and display the contents in console
* */

public class ReadPlanetData {
    public static void main( String[] args ) {

        String uri = "mongodb+srv://root:root1234@cluster0.antyn.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_guides");
            MongoCollection<Document> collection = database.getCollection("planets");

            List<Document> planets =  new ArrayList<>();

            FindIterable <Document> iterable = collection.find();
            iterable.into(planets);
            System.out.println(planets);

            // to query Planets in Compass
            //{orderFromSun:{$lte:4}}
            //{name:{$eq: "Jupiter"}}
            //{name:{$not{$eq:"Earth"}}}
            //{"surfaceTemperatureC.max":{$lte:200}}
            //{mainAtmosphere:{$elemMatch:{$not:{$eq:"He"}}}}



        }
    }
}