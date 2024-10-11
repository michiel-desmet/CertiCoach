package com.ittopdogs.certicoach.repository;

import com.ittopdogs.certicoach.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
