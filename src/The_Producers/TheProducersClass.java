package The_Producers;

import Array.*;
import Scenery.*;
import Staff.StaffMembers.*;
import Staff.*;
import Staff.Tags.*;
import java.time.LocalDateTime;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Implementa TheProducers.
 */
public class TheProducersClass implements TheProducers {

    //Variaveis
    private final Array<Recording> plannedRecordings;
    private final Array<Recording> pastRecordings;
    private final Array<StaffMember> staff;
    private final Array<Scenery> sceneries;

    //Construtor
    public TheProducersClass(){
        staff = new ArrayClass<StaffMember>();
        plannedRecordings = new ArrayClass<Recording>();
        pastRecordings = new ArrayClass<Recording>();
        sceneries = new ArrayClass<Scenery>();
    }

    @Override
    public void register(String name, int payPerHour, String type, String subType) {
        StaffType ST = getType(type,subType);

        switch(ST){
            case SENIOR_PRODUCER:
                staff.add(new SeniorProducerClass(name,payPerHour));
                break;

            case JUNIOR_PRODUCER:
                staff.add(new JuniorProducerClass(name,payPerHour));
                break;

            case VEDETTE_ACTOR:
                staff.add(new VedetteActorClass(name,payPerHour));
                break;

            case NORMAL_ACTOR:
                staff.add(new NormalActorClass(name,payPerHour));
                break;

            case VEDETTE_DIRECTOR:
                staff.add(new VedetteDirectorClass(name,payPerHour));
                break;

            case NORMAL_DIRECTOR:
                staff.add(new NormalDirectorClass(name,payPerHour));
                break;

            case TECHNICIAN:
                staff.add(new TechnicianClass(name,payPerHour));
        }
    }

    @Override
    public void addScenery(String site, int pricePerHour){
        sceneries.add(new SceneryClass(site, pricePerHour));
    }

    @Override
    public boolean isDateValid(int[] dateArray){
        LocalDateTime date = LocalDateTime.of(dateArray[0],dateArray[1],dateArray[2],dateArray[3],dateArray[4]);
        pastRecordings.initialize();
        if(pastRecordings.hasNext()) {
            LocalDateTime lastRecordingDate = pastRecordings.next().getStartingDate();
            return lastRecordingDate.isBefore(date);
        }
        return true;
    }

    @Override
    public String listSceneries(){

        String msg = "";

        sceneries.initialize();

        while(sceneries.hasNext()){
            Scenery somewhereovertherainbow = sceneries.next();
            msg += somewhereovertherainbow.getName() + " " + somewhereovertherainbow.getPricePerHour() + ".\n";
        }
        return msg;
        }

    /**
     * Verifica e devolve o tipo do Colaborador.
     *
     * @param ST - Colaborador.
     * @return tipo e sub tipo.
     */
    private StaffType checkType(StaffMember ST){
        if(ST instanceof Vedette) {
                 if(ST instanceof Actor)
                     return StaffType.VEDETTE_ACTOR;
                 else
                    return StaffType.VEDETTE_DIRECTOR;
        } else {
            if (ST instanceof Producer) {
                if (ST instanceof JuniorProducerClass)
                    return StaffType.JUNIOR_PRODUCER;
                else
                    return StaffType.SENIOR_PRODUCER;
            } else if (ST instanceof Actor)
                return StaffType.NORMAL_ACTOR;

            else if (ST instanceof Director)
                return StaffType.NORMAL_DIRECTOR;

            else
                return StaffType.TECHNICIAN;
        }
    }


    @Override
    public String record(){
        Recording recording = plannedRecordings.remove();
        String msg;
        pastRecordings.add(recording);
        if(recording.isSuspended())
            msg =  recording.toStringExtra().replaceFirst(" Suspensa!"," Cancelada!");
        else
            msg = recording.toStringExtra() + " Gravada!";
        return msg;
    }

    @Override
    public String site(String site){
        String msg = "";
        Recording recording;
        int totalCost = 0;
        plannedRecordings.initialize();
        while(plannedRecordings.hasNext()){
            recording = plannedRecordings.next();
            if(site.equals(recording.getScenery())){
                totalCost += recording.getCost();
                msg += recording.toStringExtra().replaceFirst(site + "; ","") + "\n";
            }
        }
        msg += totalCost + " euros orcamentados.";
        return msg;
    }

    @Override
    public String staffMember(String name){
        String msg = "";
        int totalCost = 0;
        plannedRecordings.initialize();
        while(plannedRecordings.hasNext()){
            Recording recording = plannedRecordings.next();
            if(recording.hasStaffMemberNamed(name)){
                totalCost += recording.getCost();
                msg += recording.toStringExtra().replaceFirst(recording.getScenery() + "; ","") + "\n";
            }
        }
        msg += totalCost + " euros orcamentados.";
        return msg;
    }

    @Override
    public boolean isThereASiteNamed(String scenery) {
        sceneries.initialize();
        while(sceneries.hasNext())
            if(sceneries.next().getName().equals(scenery))
                return true;
        return false;
    }

    @Override
    public boolean isThereAStaffMemberNamed(String name) {
        staff.initialize();
        while(staff.hasNext())
            if(staff.next().getName().equals(name))
                return true;
        return false;
    }

    @Override
    public String listPlannedRecordings(){
        String money = " euros orcamentados.";
        int totalCost = 0;
        String msg = "";
        plannedRecordings.initialize();
        if(plannedRecordings.hasNext()) {
            while (plannedRecordings.hasNext()) {
                Recording R = plannedRecordings.next();
                totalCost += R.getCost();
                msg += R.toStringExtra() + "\n";
            }
            msg += totalCost + money;
        }
        return msg;
    }

    @Override
    public String listPerformedRecordings(){
        String money = " euros gastos.";
        int totalCost = 0;
        String msg = "";
        pastRecordings.initialize();
        if(pastRecordings.hasNext()) {
            while (pastRecordings.hasNext()) {
                Recording R = pastRecordings.next();
                if(!R.isSuspended())
                    totalCost += R.getCost();
                msg += R.toStringExtra() + "\n";
            }
            msg += totalCost + money;
        }
        return msg.replaceAll(" Suspensa!\n"," Cancelada!\n");
    }

    @Override
    public int mope(String bullyName, String victimName){
        String[] bully = {bullyName};
        Vedette bullyMember = (Vedette) getStaffMembersByName(bully)[0];

        String[] victim = {victimName};
        StaffMember victimMember = getStaffMembersByName(victim)[0];

        bullyMember.mope(victimMember);
        return suspendRecordings(bullyName,victimName);
    }

    @Override
    public boolean isThereAFightWith(String exBullyName, String exVictimName) {
        String[] bully = {exBullyName};
        Vedette bullyMember = (Vedette) getStaffMembersByName(bully)[0];
        return checkFight(bullyMember,exVictimName);
    }

    @Override
    public boolean isThereAVedetteNamed(String name){
        staff.initialize();
        while(staff.hasNext()) {
            StaffMember sT = staff.next();
            if(sT.getName().equals(name) && sT instanceof Vedette)
                return true;
        }
        return false;
    }

    @Override
    public boolean isDurationValid(int duration) {
        return duration > 0;
    }

    @Override
    public boolean isThereAProducerNamed(String name) {
        staff.initialize();
        while(staff.hasNext()) {
            StaffMember sT = staff.next();
            if(sT.getName().equals(name) && sT instanceof Producer)
                return true;
        }
        return false;
    }

    @Override
    public boolean isThereADirectorNamed(String name) {
        staff.initialize();
        while(staff.hasNext()) {
            StaffMember sT = staff.next();
            if(sT.getName().equals(name) && sT instanceof Director)
                return true;
        }
        return false;
    }

    @Override
    public boolean isThereATechnicianNamed(String name) {
        staff.initialize();
        while(staff.hasNext()) {
            StaffMember sT = staff.next();
            if(sT.getName().equals(name) && sT instanceof TechnicianClass)
                return true;
        }
        return false;
    }

    @Override
    public boolean isThereStaffMembersNamed(String[] names, int numberOfStaffMembers) {
        for(int i = 2; i < numberOfStaffMembers; i++)
            if(!isThereAStaffMemberNamed(names[i]))
                return false;
        return true;
    }

    @Override
    public boolean isThereFightsBetweenThisStaff(String[] names) {
        for(String name1: names)
            for (String name: names)
             if(isThereAVedetteNamed(name1))
                 if(isThereAFightWith(name1,name))
                     return true;
        return false;
    }

    @Override
    public boolean isThereDatesConflict(String scenery, int[] date, String[] names) {
       Array<Recording> recordings = conflictedRecordings(scenery,date,names);
        recordings.initialize();
       if(!recordings.hasNext())
           return false;

       else return !isRecordingRescheduable(recordings, names[0]);
    }

    /**
     * Verifica se as gravacoes sao reagendaveis.
     *
     * @param recordings - Objeto Vetor que contem as gravacoes conflituosas
     * @param producerName - Nome do produtor da Gravacao a ser criada.
     * @return true se for possivel reagendamento;
     *         false se nao for possivel.
     */
    private boolean isRecordingRescheduable(Array<Recording> recordings, String producerName){
        String[] recordingProducer = {producerName};
        StaffType recordingProducerType = checkType(getStaffMembersByName(recordingProducer)[0]);
        if(recordingProducerType.equals(StaffType.JUNIOR_PRODUCER))
            return false;
        recordings.initialize();
        for (int i = 0; i < recordings.length() ; i++) {
            Recording recording = recordings.next();
            StaffType plannedRecordingProducerType = checkType(recording.getProducer());
            if(!plannedRecordingProducerType.equals(StaffType.JUNIOR_PRODUCER)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void reschedule(String sceneryName, int[] date, String[] names) {
        Array<Recording> recordings = conflictedRecordings(sceneryName, date, names);
        recordings.initialize();
        while (recordings.hasNext())
            plannedRecordings.remove(recordings.next());
        scheduleRecording(sceneryName, date, names, false);

        recordings.initialize();
        while(recordings.hasNext()){

            Recording recording2reschedule = recordings.next();
            LocalDateTime tempStartDate = LocalDateTime.of(date[0], date[1], date[2],date[3], date[4]).plusDays(1);
            LocalDateTime tempEndDate = tempStartDate.plusMinutes(recording2reschedule.getDuration());
            plannedRecordings.initialize();
            boolean rescheduled = false;
            while(plannedRecordings.hasNext() && !rescheduled) {
                Recording recording = plannedRecordings.next();
                if (isDateConflicted(tempStartDate, tempEndDate, recording) &&
                    (isThereStaffIntersection(recording, recording2reschedule.getStaff()) ||
                    isThereSceneryIntersection(recording, recording2reschedule.getScenery()))){

                    tempStartDate = tempStartDate.plusDays(1);
                    tempEndDate = tempEndDate.plusDays(1);
                }
                else {
                    int index = getChronologicalPos(tempStartDate);
                    recording2reschedule.changeDate(tempStartDate);
                    plannedRecordings.add(recording2reschedule, index);
                    rescheduled = true;
                }
            }
        }
    }

    /**
     * Verifica e devolve um Objeto Vetor que contem todas as gravacoes conflituosas de acordo com uma gravacao
     *
     * @param sceneryName - Nome do Cenario da Gravacao a agendar.
     * @param date - Data da gravacao
     * @param names - Nomes dos Colaboradores participantes na Gravacao.
     * @return recordings.
     */
    private Array<Recording> conflictedRecordings(String sceneryName, int[] date, String[] names){
        Array<Recording> recordings = new ArrayClass<Recording>();
        LocalDateTime realDate = LocalDateTime.of(date[0], date[1], date[2], date[3], date[4]);
        plannedRecordings.initialize();
        while(plannedRecordings.hasNext()) {
            Recording recording = plannedRecordings.next();
            if(isDateConflicted(realDate,realDate.plusMinutes(date[5]),recording) && (isThereSceneryIntersection(recording,sceneryName) || isThereStaffIntersection(recording,names)))
                recordings.add(recording);
       }
       return recordings;
    }

    /**
     * Verifica se a data de uma gravacao interseta com outra data de um gravacao dada.
     *
     * @param realDateStart - Data de inicio da Gravacao.
     * @param realDateEnd - Data de fim da Gravacao.
     * @param recording - Gravacao para comparar datas.
     * @return true se houve interseccao;
     *         false se nao houver.
     */
    private boolean isDateConflicted(LocalDateTime realDateStart, LocalDateTime realDateEnd,Recording recording){
        LocalDateTime startingDate = recording.getStartingDate();
        LocalDateTime endDate = recording.getEndDate();
        return ! (((realDateStart.isBefore(startingDate) && realDateEnd.isBefore(startingDate)) || realDateStart.isAfter(endDate)));
    }

    /**
     *Verifica se existe Colaboradores comuns de uma recording dada com o vetor de nomes dos Colaboradores dado.
     *
     * @param recording - Gravacao a comparar.
     * @param names - Nomes dos Colaboradores.
     * @return true se existir nomes em comum;
     *         false se nao existir.
     */
    private boolean isThereStaffIntersection(Recording recording, String[] names){
        int namesCounter = 0;
        while (namesCounter != names.length){
             if (recording.hasStaffMemberNamed(names[namesCounter]))
                 return true;
              else
                  namesCounter++;
         }
         return false;
    }

    /**
     * Verifica se o cenario da gravacao tem o nome dado.
     *
     * @param recording - Gravacao
     * @param sceneryName - Nome do Cenario.
     * @return true se for o mesmo nome;
     *         false se nao for o mesmo nome.
     */
    private boolean isThereSceneryIntersection(Recording recording, String sceneryName) {
        return recording.getScenery().equals(sceneryName);
    }

    /**
     * Verifica se existe uma zanga entre uma vedeta dada e um Colaborador com o nome dado.
     *
     * @param vedette - Vedeta
     * @param victimName -  Nome do Colaborador vitima.
     * @return true se houver zanga;
     *         false se nao houver zanga.
     */
    private boolean checkFight(Vedette vedette,String victimName) {
        return vedette.isMadWith(victimName);
    }

    @Override
    public int reconcile(String exBullyName, String exVictimName){
        String[] bully = {exBullyName};
        Vedette bullyMember = (Vedette)getStaffMembersByName(bully)[0];
        bullyMember.reconcile(exVictimName);
        return unSuspendRecordings(exBullyName,exVictimName);
    }

    /**
     * Descobre quantas gravacoes foram salvas devido ao fim da zanga da vedeta e vitima com nomes dados.
     *
     * @param exBullyName - Nome da Vedeta.
     * @param exVictimName -  Nome do Colaborador vitima.
     * @return nUnsuspended.
     */
    private int unSuspendRecordings(String exBullyName, String exVictimName) {
        int nUnSuspended = 0;
        plannedRecordings.initialize();
        while(plannedRecordings.hasNext()){
            Recording recording = plannedRecordings.next();
            if(recording.hasStaffMemberNamed(exVictimName) && recording.hasStaffMemberNamed(exBullyName) && recording.isRecordingSaved()) {
                recording.changeStatus();
                nUnSuspended++;
            }
        }
        return nUnSuspended;
    }

    /**
     * Descobre quantas gravacoes foram suspensas devido ao inicio da zanga da vedeta e vitima com nomes dados.
     *
     * @param bullyName - Nome da Vedeta.
     * @param victimName -  Nome do Colaborador vitima.
     * @return nSuspended.
     */
    private int suspendRecordings(String bullyName, String victimName){
        int nSuspended = 0;
        plannedRecordings.initialize();
        while(plannedRecordings.hasNext()){
            Recording recording = plannedRecordings.next();
            if(recording.hasStaffMemberNamed(victimName) && recording.hasStaffMemberNamed(bullyName) && !recording.isSuspended()) {
                recording.changeStatus();
                nSuspended++;
            }
        }
        return nSuspended;
    }

    @Override
    public String poutances(String name){
        String[] vedette = {name};
        Vedette vedetteMember = (Vedette)getStaffMembersByName(vedette)[0];
        return vedetteMember.getBlacklist();
    }

    @Override
    public String staff() {
        staff.initialize();
        String msg = "";

        while(staff.hasNext()){
            StaffMember jonhdoe = staff.next();
            StaffType ST = checkType(jonhdoe);
            msg += ST.getOutput() + jonhdoe.getName() + " " + jonhdoe.getMoneyPerHour() + "\n";
        }
        return msg;
    }

    @Override
    public boolean isTypeValid(String type){

        for(StaffType ST: StaffType.values())
            if(ST.getType().equals(type))
                return true;
        return false;
    }

    @Override
    public boolean isSubTypeValid(String subType){
        for(StaffType ST: StaffType.values())
            if(ST.getSubType().equals(subType))
                return true;
        return false;
    }

    @Override
    public boolean isCostInvalid(int cost){
        return cost <= 0;
    }

    public boolean duplicateSceneryName(String name){
        sceneries.initialize();
        while(sceneries.hasNext()){
            if(sceneries.next().getName().equals(name))
                return true;
        }
        return false;
    }

    /**
     * Devolve o objeto StaffType com o tipo e sub tipo dado.
     *
     * @param type - tipo principal.
     * @param subType - sub tipo.
     * @return StaffType.
     */
    private StaffType getType(String type, String subType){
        for (StaffType T: StaffType.values()) {
            if(type.equals(T.getType()) && subType.equals(T.getSubType()))
                return T;
        }
        return null;
    }

    @Override
    public void scheduleRecording(String scenery, int[] localDateTime, String[] names,boolean suspended){
        LocalDateTime date = LocalDateTime.of(localDateTime[0],localDateTime[1],localDateTime[2],localDateTime[3],localDateTime[4]);
        int duration = localDateTime[5];
        plannedRecordings.add(new RecordingClass(getSceneryByName(scenery), date, duration, getStaffMembersByName(names),suspended),getChronologicalPos(date));
    }

    @Override
    public boolean isReschuleNeeded(String scenery, int[] date, String[] names){
        Array<Recording> recordings = conflictedRecordings(scenery,date,names);
        recordings.initialize();
        return recordings.hasNext();
    }

    /**
     * Descobre e devolve o indice onde uma data de uma Gravacao deve ser colocado de ordem cronologica.
     *
     * @param date -  Data da Gravacao.
     * @return index.
     */
    private int getChronologicalPos(LocalDateTime date){
    plannedRecordings.initialize();
    while(plannedRecordings.hasNext()){
        Recording recording = plannedRecordings.next();
        if(recording.getStartingDate().isAfter(date))
            return plannedRecordings.getCurrentElem();
    }
        return plannedRecordings.length();
    }

    /**
     * Devolve o cenario com o nome dado.
     *
     * @param name - Nome do Cenario
     * @return Scenery.
     */
    private Scenery getSceneryByName(String name){
        sceneries.initialize();
        while(sceneries.hasNext()) {
            Scenery sC = sceneries.next();
            if (sC.getName().equals(name))
                return sC;
        }
            return null;
    }

    /**
     * Devolve um vetor com Colaboradores de acordo com os nomes guardados num vetor dado.
     *
     * @param names - Nomes dos Colaboradores.
     * @return ArrayStaffMembers.
     */
    private StaffMember[] getStaffMembersByName(String[] names) {
        int counter = 0;
        int length = names.length;
        StaffMember[] staff = new StaffMember[length];
        this.staff.initialize();
        while (this.staff.hasNext() && counter < length){
            StaffMember sM = this.staff.next();
            if (sM.getName().equals(names[counter])) {
                staff[counter++] = sM;
                this.staff.initialize();
            }
        }
            return staff;
    }
}
