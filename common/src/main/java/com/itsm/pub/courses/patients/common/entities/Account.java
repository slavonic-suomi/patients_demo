package com.itsm.pub.courses.patients.common.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
@Entity(name = "Account")
@Table(name = "account")
@SecondaryTable(
        name = "account_details"
)
@SQLDelete(
        sql = "UPDATE account_details SET deleted = true WHERE id = ? "
)
@FilterDef(
        name="activeCommentedAccount",
        parameters = @ParamDef(
                name="active",
                type="boolean"
        )
)
@Filter(
        name="activeCommentedAccount",
        condition="{a}.active = :active and {ad}.operatorComment is not null",
        aliases = {
                @SqlFragmentAlias( alias = "a", table= "account"),
                @SqlFragmentAlias( alias = "ad", table= "account_details"),
        }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
*/
public class Account {
   // @Id
    private Long id;

    private Double amount;

    private Double rate;

    private boolean active;

    private boolean deleted;

    //@Column(table = "account_details")
    private String operatorComment;
}
