import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BasicAllocator {
 /*   @Override
    public Patient allocatePatient(Doctor doctor, TreatmentUnit treatmentUnit) {
        List<Patient> patients = treatmentUnit.getAllPatients().stream().filter(patient -> doctor.canTreat(patient) != 0).collect(Collectors.toList());

        return patients.isEmpty() ? null : patients.get(0);
    }

    @Override
    public Doctor allocateDoctor(Patient patient, TreatmentUnit treatmentUnit) {
        Collection<Doctor> patients = treatmentUnit.getAvailableDoctors();
        return patients.isEmpty() || !treatmentUnit.getWaitingPatients().isEmpty()? null : patients.iterator().next();
    }
*/}
