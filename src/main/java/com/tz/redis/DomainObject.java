package com.tz.redis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author TZ
 * 
 */
import java.io.Serializable;

public interface DomainObject extends Serializable {
 
 String getKey();
 
 String getObjectKey();
}