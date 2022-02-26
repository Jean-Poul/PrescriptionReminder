package cph.databases.assignment.utils;

import org.springframework.stereotype.Service;

@Service
public class Creator {
/*
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
                dose.setDrug(drug);
                doseRepo.save(dose);
                System.out.println(counter);
                counter++;
            }
        }
    }

 */
}
