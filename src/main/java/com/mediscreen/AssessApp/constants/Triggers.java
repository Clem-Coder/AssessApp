package com.mediscreen.AssessApp.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Triggers {

    public static final List<String> TRIGGERS = Collections.unmodifiableList(
            new ArrayList<String>() {{
                add("Hémoglobine A1C");
                add("Microalbumine");
                add("Taille");
                add("Poids");
                add("Fumeur");
                add("Anormal");
                add("Cholestérol");
                add("Rechute");
                add("Réaction");
                add("Anticorps");
            }});
}
