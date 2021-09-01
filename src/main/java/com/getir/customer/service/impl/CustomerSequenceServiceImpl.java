package com.getir.customer.service.impl;

import com.getir.customer.model.CustomerSequence;
import com.getir.customer.service.CustomerSequenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
@Service
@RequiredArgsConstructor
public class CustomerSequenceServiceImpl implements CustomerSequenceService {

    private final MongoOperations mongoOperations;

    @Override
    public int getSequenceNumber(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq", 1);
        //modify in document
        CustomerSequence counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        CustomerSequence.class);

        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
