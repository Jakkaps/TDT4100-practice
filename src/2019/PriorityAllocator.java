import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PriorityAllocator extends BasicAllocator {
  /*  @Override
    public Patient allocatePatient(Doctor doctor, TreatmentUnit treatmentUnit) {
        List<Patient> patients = treatmentUnit.getWaitingPatients().stream()
                .filter(patient -> doctor.canTreat(patient) != 0).collect(Collectors.toList());

        if (!patients.isEmpty()){
            patients.sort(Comparator.comparing(Patient::getPriority));
            return patients.get(0);
        }

        return null;
    }

    @Override
    public Doctor allocateDoctor(Patient patient, TreatmentUnit treatmentUnit) {
        List<Doctor> doctors = treatmentUnit.getAvailableDoctors()
                .stream()
                .filter(doctor -> doctor.canTreat(patient) != 0)
                .collect(Collectors.toList());

        return getPriorityDoctor(patient, treatmentUnit, doctors);
    }*/
}
