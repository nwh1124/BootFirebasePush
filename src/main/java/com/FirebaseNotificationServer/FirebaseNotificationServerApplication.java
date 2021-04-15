package com.FirebaseNotificationServer;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirebaseNotificationServerApplication {
	
    private FirebaseOptions option;
    private Firestore db; 
    private final static String PATH = "C:/Users/Myojol/AndroidStudioProjects/prac/app/google-services.json";
    private final static String COLLECTION_NAME = "컬렉션";

    public static void main( String[] args ) {
    	FirebaseNotificationServerApplication app = new FirebaseNotificationServerApplication();
        try {
            app.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void init() throws Exception{
        FileInputStream refreshToken = new FileInputStream(PATH);
        option = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(refreshToken))
                .setDatabaseUrl("https://데이터베이스주소.firebaseio.com")  //내 저장소 주소
                .build();
        FirebaseApp.initializeApp(option);
    }

}
