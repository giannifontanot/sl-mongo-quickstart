package org.lionheart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;


public class FindOneShipwreck {

    public static void main(String[] args){

        String mongoUri = "mongodb+srv://root:root1234@cluster0.antyn.mongodb.net/?retryWrites=true&w=majority";

        try(MongoClient mongoClient = MongoClients.create(mongoUri)){
            MongoDatabase database = mongoClient.getDatabase("sample_guides");
            MongoCollection<Document> collection =  database.getCollection("planets");


            Bson projectionFields = Projections.fields(
                    Projections.include("name", "orderFromSun", "hasRings"),
                    Projections.excludeId());

            Document doc = collection.find(eq("name", "Mars"))
                    .projection(projectionFields)
                    .sort(Sorts.ascending("orderFromSun"))
                    .first();
            System.out.println(doc.toJson());
}}}
