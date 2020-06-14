package Rubenvdbrink.app.persistance;

import Rubenvdbrink.app.model.App;
import Rubenvdbrink.app.model.MyUser;
import Rubenvdbrink.app.model.Product;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;

import java.io.*;

public class PersistanceManager {
    private final static String ENDPOINT = "https://vitshop1.blob.core.windows.net/";
    private final static String SASTOKEN = "?sv=2019-10-10&ss=bfqt&srt=co&sp=rwdlacupx&se=2020-12-31T21:07:21Z&st=2020-05-24T12:07:21Z&spr=https&sig=SNs%2Fvf7PF8VLyhnVpsfnnRe3bwKanNXtqFFsSeHsgpA%3D";
    private final static String CONTAINER = "vitshopcontainer";

    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SASTOKEN)
            .containerName(CONTAINER)
            .buildClient();

    public static void saveDataToAzure() throws IOException {
        if(!blobContainer.exists()) {
            blobContainer.create();
        }

        App.getApp().setAlleProducten(Product.getAlleProducten());
        App.getApp().setAlleUsers(MyUser.getAllMyUsers());

        BlobClient blob = blobContainer.getBlobClient("datablob");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(App.getApp());

        byte[] bytez = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blob.upload(bais, bytez.length, true);

        oos.close();
        bais.close();
    }

    public static void loadDataFromAzure() throws IOException, ClassNotFoundException {
        if(blobContainer.exists()) {

            BlobClient blob = blobContainer.getBlobClient("datablob");

            if (blob.exists()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blob.download(baos);

                byte[] bytez = baos.toByteArray();

                ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
                ObjectInputStream ois = new ObjectInputStream(bais);

                App loadedApp = (App) ois.readObject();

                App.setApp(loadedApp);

                loadedApp.loadData(); //Hier wordt alle data van de gehele app opnieuw geset in alle klassen

                baos.close();
                ois.close();
            }
        }
    }
}
