package com.traider.journal.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Coin {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     Long id;
     String name;
     Date updated;
}
