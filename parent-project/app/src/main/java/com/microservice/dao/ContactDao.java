package com.microservice.dao;

import com.microservice.dao.mappers.ContactMapper;
import com.microservice.representation.Contact;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

public interface ContactDao {
    @Mapper(ContactMapper.class)
    @SqlQuery("select * from contacts where id = :id")
    Contact getContactById(@Bind("id") int id);

    @Mapper(ContactMapper.class)
    @SqlQuery("select * from contacts")
    List<Contact> getContacts();
}