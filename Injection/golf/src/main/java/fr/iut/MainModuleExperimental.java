package fr.iut;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import fr.iut.club.Putter;
import fr.iut.club.PutterExperimental;
import fr.iut.club.Wood;


public class MainModuleExperimental extends AbstractModule {

    protected void configure() {
        bind(Caddy.class);
        bind(Club.class).annotatedWith(Names.named("Putter")).to(PutterExperimental.class);
        bind(Club.class).annotatedWith(Names.named("Wood")).to(Wood.class);
    }
}
