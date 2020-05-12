import java.util.Collection;
import java.util.function.Predicate;

/**
 * A class for managing a set of doctors and the patients they're treating.
 * When doctors or patients arrive, or a doctor finishes a treatment,
 * it is made sure that patients are treated as soon as possible.
 */
public class TreatmentUnit {
   /* private DoctorAllocator allocator;

    public void addDoctor(final Doctor doctor) {
        // Implementation hidden
    }


    public Collection<Doctor> getAllDoctors() {
        // Implementation hidden
    }


    public Collection<Doctor> getAvailableDoctors() {
        // Implementation hidden
    }


    public void addPatient(final Patient patient) {
        // Implementation hidden
    }


    public Doctor getDoctor(final Predicate<Doctor> pred) {
        // Implementation hidden
    }


    public Doctor getDoctor(final Patient patient) {
        // Implementation hidden
    }


    public Collection<Patient> getAllPatients() {
        // Implementation hidden
    }


    public Collection<Patient> getWaitingPatients() {
        // Implementation hidden
    }



    protected boolean startTreatment(final Doctor doctor) { // Part 4
        final Patient patient = allocator.allocatePatient(doctor, this);

        if (patient != null) {
            doctor.setPatient(patient);
            return true;
        }

        return false;
    }


    protected boolean startTreatment(final Patient patient) { // Part 4
        final Doctor doctor = allocator.allocateDoctor(patient, this);
        if (doctor != null) {
            doctor.setPatient(patient);
            return true;
        }

        return false;
    }


    public void treatmentFinished(final Doctor doctor) {
        // Implementation hidden
    }*/
}
