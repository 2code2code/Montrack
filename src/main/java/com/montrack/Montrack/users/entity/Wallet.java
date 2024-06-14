package com.montrack.Montrack.users.entity;

import com.montrack.Montrack.users.entity.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    @ColumnDefault("nextval('wallets_wallet_id_seq'::regclass)")
    @Column(name = "wallet_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "balance", precision = 15, scale = 2)
    private BigDecimal balance;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @ColumnDefault("0.00")
    @Column(name = "currency_id")
    private Integer currencyId;

    @Column(name = "is_active")
    private Boolean isActive;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

}