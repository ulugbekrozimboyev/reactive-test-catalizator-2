package uz.ulugbek.reactive.catalizator.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.ulugbek.reactive.catalizator.model.Message;
import uz.ulugbek.reactive.catalizator.repository.MessageRepository;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Flux<Message> getMessages(){
        return messageRepository.findAll();
    }

    public Mono<Message> save(Message message){
        return messageRepository.save(message);
    }
}

