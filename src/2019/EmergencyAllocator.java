import java.util.List;
import java.util.stream.Collectors;

public class EmergencyAllocator extends PriorityAllocator{
   /* @Override
    public Doctor allocateDoctor(Patient patient, TreatmentUnit treatmentUnit) {
        List<Doctor> doctors = treatmentUnit.getAllDoctors()
                .stream()
                .filter(doctor -> doctor.canTreat(patient) != 0)
                .collect(Collectors.toList());

        return getPriorityDoctor(patient, treatmentUnit, doctors);
    }

    static Doctor getPriorityDoctor(Patient patient, TreatmentUnit treatmentUnit, List<Doctor> doctors) {
        for (Doctor doctor : doctors){
            List<Patient> higherPriorityPatients = treatmentUnit.getWaitingPatients().stream()
                    .filter(otherPatient -> doctor.canTreat(otherPatient) != 0)
                    .filter(otherPatient -> otherPatient.getPriority() > patient.getPriority()).collect(Collectors.toList());

            if (higherPriorityPatients.isEmpty()){
                return doctor;
            }
        }

        return null;
    }*/

}
