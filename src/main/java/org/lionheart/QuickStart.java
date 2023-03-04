package org.lionheart;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class QuickStart {
    /*
     * What did I learn?
     * how to retrieve data from Atlas
     * which database and which table (collection)
     * find the first item of a collection
     * */
    public static void main( String[] args ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://root:root1234@cluster0.antyn.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("travel-blog-db");
            MongoCollection<Document> collection = database.getCollection("trips");

            Document doc = collection.find(eq("tripTitle", "Paris")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }
}