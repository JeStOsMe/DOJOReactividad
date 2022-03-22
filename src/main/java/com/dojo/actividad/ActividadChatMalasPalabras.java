package com.dojo.actividad;

import java.util.ArrayList;
import java.util.List;

import com.dojo.actividad.models.Chat;
import com.dojo.actividad.models.MalasPalabras;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import reactor.core.publisher.Flux;

public class ActividadChatMalasPalabras implements CommandLineRunner{

    public static void main(String[] args) {
		SpringApplication.run(ActividadApplication.class, args);
	}
    
    @Override
    public void run(String... args) throws Exception {
        List<MalasPalabras> malasPalabras = generadorDeMalasPalabras();
        List<Chat> chat = generadorDeChat();

        System.out.println("\n\n\tEJERCICIO 2");
        Flux.fromIterable(chat)
            .map(mensaje -> {
                malasPalabras.forEach(palabra -> {
                    if (mensaje.getChat().toUpperCase().contains(palabra.getMalaPalabra().toUpperCase())){
                        mensaje.transformarAPalabraCorrecta(palabra.getMalaPalabra().toUpperCase());
                    }
                });
                return mensaje;
            })
            .subscribe(mensaje -> System.out.println("Mensaje: " + mensaje));
        
    }

    public List<MalasPalabras> generadorDeMalasPalabras(){
        List<MalasPalabras> malasPalabras = new ArrayList<>();

        malasPalabras.add(new MalasPalabras("vaso"));
        malasPalabras.add(new MalasPalabras("tarro"));
        
        return malasPalabras;
    }

    public List<Chat> generadorDeChat(){
        List<Chat> chat = new ArrayList<>();

        chat.add(new Chat("Resulta y acontece que este vaso está roto"));
        chat.add(new Chat("Darme un tarro de cerveza"));
        chat.add(new Chat("Hola. Buenos días"));
        chat.add(new Chat("Realmente, un tarro y un vaso funcionan para lo mismo"));
        chat.add(new Chat("Realmente, un tArRo y un VasO funcionan para lo mismo"));

        return chat;
    }
    
}
