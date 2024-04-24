package com.studentManagement.entity.semester;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TransactionId
{
    @Id
    private String transactionid;

    public TransactionId()
    {

    }

    public TransactionId(String transactionid)
    {
        this.transactionid = transactionid;
    }

    public String getTransactionid()
    {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }
}
