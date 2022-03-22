package com.dojo.actividad;

import java.util.ArrayList;
import java.util.List;

import com.dojo.actividad.models.Chat;
import com.dojo.actividad.models.MalasPalabras;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ActividadChatMalasPalabras implements CommandLineRunner{

    public static void main(String[] args) {
		SpringApplication.run(ActividadApplication.class, args);
	}
    
    @Override
    public void run(String... args) throws Exception {
        List<MalasPalabras> malasPalabras = generadorDeMalasPalabras();
        List<Chat> chat = generadorDeChat();

        Flux.fromIterable(chat)
            .map(mensaje -> {
                malasPalabras.forEach(palabra -> {
                    if (mensaje.getChat().contains(palabra.getMalaPalabra())){
                        //Falta lógica
                    }
                });
            })
            .subscribe();
        
    }

    public List<MalasPalabras> generadorDeMalasPalabras(){
        List<MalasPalabras> malasPalabras = new ArrayList<>();

        malasPalabras.add(new MalasPalabras("vaso"));
        
        return malasPalabras;
    }

    public List<Chat> generadorDeChat(){
        List<Chat> chat = new ArrayList<>();

        chat.add(new Chat("Resulta y acontece que este vaso está roto"));

        return chat;
    }
    
}
