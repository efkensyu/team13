package com.example.demo.team13.Team13Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "team13_shain_tbl")
@Data
public class Team13Shain {
    @Id
    @NotBlank(message="IDを入力してください")
    @Column(name = "SHAIN_ID")
    private String shainId;

    @Column(name = "SHAIN_NM")
    private String shainNm;

    @Column(name = "SHAIN_ADRESS")
    private String shainAdress;

    @NotBlank(message="メールアドレスを入力してください")
    @Column(name = "SHAIN_EMAIL")
    private String shainEmail;

    @Column(name = "SHAIN_TELL")
    private String shainTell;
}
