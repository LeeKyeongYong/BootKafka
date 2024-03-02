package com.study2.kafkabasic2.global.jpa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.domain.Persistable;

import static jakarta.persistence.GenerationType.IDENTITY;
import static jakarta.persistence.GenerationType.IDENTITY;
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseEntity implements Persistable<Long> {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Override
    public boolean isNew() {
        return id==null;
    }

    public String getModelName(){
        String simpleName = this.getClass().getSimpleName();
        return Character.toLowerCase(simpleName.charAt(0))+simpleName.substring(1);
    }
}
