package com.tngtech.flink.connector.email.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.tngtech.flink.connector.email")
public class ArchitectureTest {

    @ArchTest
    private final ArchRule imapDoesNotDependonSmtp = noClasses()
        .that()
        .resideInAPackage("..imap..")
        .should()
        .dependOnClassesThat()
        .resideInAPackage("..smtp..");

    @ArchTest
    private final ArchRule smtpDoesNotDependOnImap = noClasses()
        .that()
        .resideInAPackage("..imap..")
        .should()
        .dependOnClassesThat()
        .resideInAPackage("..smtp..");
}
