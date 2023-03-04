package org.lionheart;
import org.lionheart.entity.Trip;
import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class QuickStartPojoExample {
    public static void main (String[] args){
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(),fromProviders(pojoCodecProvider));

        String uri = "mongodb+srv://root:root1234@cluster0.antyn.mongodb.net/?retryWrites=true&w=majority";

        try(MongoClient mongoClient = MongoClients.create(uri)){
            MongoDatabase database = mongoClient.getDatabase("travel-blog-db").withCodecRegistry(pojoCodecRegistry);
            MongoCollection <Trip> collection = database.getCollection("trips", Trip.class);

            Trip newTrip = new Trip("SOCAL", "http://socalimage.jpg", "This is a test of a SoCal trip");
            collection.insertOne(newTrip);


//            Trip trip = collection.find(eq("tripTitle","SOCAL")).first();
List<Trip> trips = new ArrayList<>();
collection.find().into(trips);
            System.out.println(trips);
        }

    }

}
