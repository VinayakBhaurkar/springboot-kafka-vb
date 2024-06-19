package net.javaguides.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.entity.WikimediaData;
import net.javaguides.springboot.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	private WikimediaDataRepository wikimediaDataRepository;
	
	public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository) {
		super();
		this.wikimediaDataRepository = wikimediaDataRepository;
	}
	
	@KafkaListener(
			topics = "wikimedia_recentchange", 
			groupId = "myGroup"
	)
	public void consume(String eventMessage) {
		LOGGER.info(String.format("Event Message received -> %s",eventMessage));
		
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setWikimediaEventData(eventMessage);
		
		wikimediaDataRepository.save(wikimediaData);
	}


	
}
