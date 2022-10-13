package uz.ulugbek.reactive.catalizator.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import uz.ulugbek.reactive.catalizator.model.Message;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {
}
