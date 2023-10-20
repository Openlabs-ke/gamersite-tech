package org.xgamerstechnologies.com.entity;

import org.xgamerstechnologies.com.type.GenericGame;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "xbox_games")
public class XBoxGame extends GenericGame {
}
