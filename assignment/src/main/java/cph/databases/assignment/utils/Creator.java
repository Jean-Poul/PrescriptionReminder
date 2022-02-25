package cph.databases.assignment.utils;

import cph.databases.assignment.entity.prescription.Dose;
import cph.databases.assignment.entity.prescription.Drug;
import cph.databases.assignment.repository.DoseRepo;
import cph.databases.assignment.repository.DrugRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Creator {
    private static DoseRepo doseRepo;
    private static DrugRepo drugRepo;

    @Autowired
    public Creator(DoseRepo doseRepo, DrugRepo drugRepo) {
        this.doseRepo = doseRepo;
        this.drugRepo = drugRepo;
    }

    public Creator() {
    }

    public void createDoser() {
        String[] forms = {
                "pill",
                "aerosol",
                "syrup",
                "suppository",
                "powder",
                "liquid",
                "inhaler"
        };

        String[] units = {
                "mg",
                "mikg",
                "g",
                "ml"
        };

        Iterable<Drug> allDrugs = drugRepo.findAll();
        int counter = 1;
        for (Drug drug : allDrugs) {
            int rand_index = (int) ((Math.random() * (units.length)));
            String unit = units[rand_index];
            int form_q = (int) (1 + (Math.random() * (4 - 1)));
            String form = forms[form_q];
            for (int i = 0; i < form_q; i++) {
                int one_tenth_strength = (int) (1 + (Math.random() * (101 - 1)));
                Dose dose = new Dose();
                dose.setForm(form);
                dose.setUnit(unit);
                dose.setStrength(one_tenth_strength * 5);
                drug.addDose(dose);
                doseRepo.save(dose);
                System.out.println(counter);
                counter++;
            }
        }
    }
}
