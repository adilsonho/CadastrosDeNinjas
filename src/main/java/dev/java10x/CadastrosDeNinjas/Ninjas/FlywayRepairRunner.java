package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FlywayRepairRunner implements CommandLineRunner {

    private final Flyway flyway;

    public FlywayRepairRunner(Flyway flyway) {
        this.flyway = flyway;
    }

    @Override
    public void run(String... args) throws Exception {
        flyway.repair();
        System.out.println("Flyway repair executado com sucesso!");
    }
}
