package ec.edu.epn.taller2carros.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.epn.taller2carros.model.Vehiculo;
import org.bson.Document;

public class ConexionMongo {

    private static final String URI = "mongodb+srv://usuario2025a:usuario2025a@cluster0.ozrgtfw.mongodb.net/?appName=Cluster0";

    public void guardarVehiculo(Vehiculo vehiculo) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase("esfotcarDB");
            MongoCollection<Document> collection = database.getCollection("vehiculos");

            Document doc = new Document("codigo", vehiculo.getCodigo())
                    .append("marca", vehiculo.getMarca())
                    .append("modelo", vehiculo.getModelo())
                    .append("precio", vehiculo.getPrecio());

            collection.insertOne(doc);
            System.out.println(" Vehículo guardado exitosamente en Mongo Atlas.");
        } catch (Exception e) {
            System.err.println("Error al guardar en MongoDB: " + e.getMessage());
        }
    }

    // --- NUEVO MÉTODO PARA SOLICITAR LOS DATOS ---
    public Vehiculo buscarPorCodigo(String codigoBuscado) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase("esfotcarDB");
            MongoCollection<Document> collection = database.getCollection("vehiculos");


            Document filtro = new Document("codigo", codigoBuscado);


            Document resultado = collection.find(filtro).first();

            if (resultado != null) {

                return new Vehiculo(
                        resultado.getString("codigo"),
                        resultado.getString("marca"),
                        resultado.getString("modelo"),
                        resultado.getDouble("precio")
                );
            }
        } catch (Exception e) {
            System.err.println("Error al buscar en MongoDB: " + e.getMessage());
        }
        return null;
    }
}