package The_Producers;


/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Representa a Classe Topo do programa.
 */
@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public interface TheProducers {

    /**
     * Regista um novo colaborador e adiciona-o ao staff.
     *
     * @param name - Nome do Colaborador.
     * @param payPerHour - Preco por hora do Colaborador.
     * @param type - Tipo principal do Colaborador-
     * @param subType - Sub tipo do Colaborador.
     */
    void register(String name, int payPerHour, String type, String subType);

    /**
     * Regista um novo cenario.
     *
     * @param site - Nome do Cenario.
     * @param pricePerHour - Custo do Cenario por hora.
     */
    void addScenery(String site, int pricePerHour);

    /**
     * Devolve uma mensagem associado ao commando "COLABORADORES".
     *
     * @return -  msg.
     */
    String staff();

    /**
     * Devolve uma mensagem associado ao commando "CENARIOS".
     *
     * @return msg.
     */
    String listSceneries();

    /**
     * Verifica se ja existe um cenario com o nome dado.
     *
     * @param name - Nome do cenario a verificar.
     * @return true se existir;
     *         false se nao existir.
     */
    boolean duplicateSceneryName(String name);

    /**
     * Agenda um nova gravacao e adiciona a "plannedRecordings" (Gravacaoes agendadas).
     *
     * @param scenery - Nome do cenario.
     * @param localDateTime - parametros necessarios para a data num vetor de inteiros
     * @param names - Nomes do Colaboradores da gravacao num vetor de Strings.
     * @param suspended - true se a Gravacao e criada suspensa;
     *                    false se a Gravacao e criada normalmente.
     */
    void scheduleRecording(String scenery, int[] localDateTime, String[] names, boolean suspended);

    /**
     * Devolve a mensagem associada ao comando "PREVISTAS".
     *
     * @return msg
     */
    String listPlannedRecordings();

    /**
     * Devolve a mensagem associado ao comando "REALIZADAS".
     *
     * @return msg
     */
    String listPerformedRecordings();

    /**
     * "Realiza" a primeira gravacao agendada e devolve a mensagem associado ao commando "GRAVA".
     *
     * @return - msg
     */
    String record();

    /**
     * Devolve a mensagem associado ao comando "CENARIO".
     *
     * @param scenery - Nome do Cenario.
     * @return msg.
     */
    String site(String scenery);

    /**
     * Devolve a mensagem associado ao comando "COLABORADOR".
     *
     * @param name - Nome do Colaborador.
     * @return msg.
     */
    String staffMember(String name);

    /**
     * Devolve a mensagem associado ao comando "AMUANCOS".
     *
     * @param name - Nome da Vedeta
     * @return msg.
     */
    String poutances(String name);

    /**
     * Adiciona um colaborador com nome @param victimName a lista negra da vedeta com nome @param bullyName.
     * Devolve o numero da Gravacoes suspendidas.
     *
     * @param bullyName - Nome da Vedeta.
     * @param victimName - Nome do Colaborador vitima.
     * @return - nSuspended.
     */
    int mope(String bullyName, String victimName);

    /**
     * Retira o colaborador com nome @param victimName da lista negra da vedeta com nome @param bullyName.
     * Devolve o numero da Gravacoes salvas.
     *
     * @param exBullyName - Nome da Vedeta-
     * @param exVictimName - Nome do Colaborador vitima.
     * @return - nUnsuspended.
     */
    int reconcile(String exBullyName, String exVictimName);

    /**
     * Verifica se o sub tipo dado e valido.
     *
     * @param subType - Nome do sub Tipo.
     * @return true se existe esse sub tipo;
     *         false se nao existir.
     */
    boolean isSubTypeValid(String subType);

    /**
     * Verifica se o custo por hora e valido.
     *
     * @param cost - Custo por hora.
     * @return true se for <= 0;
     *         false se for > 0.
     */
    boolean isCostInvalid(int cost);

    /**
     * Verifica se a data e valida comparando com a primeira data das gravacoes realizadas.
     *
     * @param dateArray - vetor de argumentos para criar uma data.
     * @return true se for valida;
     *         false se for invalida.
     */
    boolean isDateValid(int[] dateArray);

    /**
     * Verifica se existe um colaborador com o nome dado.
     *
     * @param name - Nome do Colaborador.
     * @return true se existir um Colaborador com esse nome;
     *         false se nao exiistir.
     */
    boolean isThereAStaffMemberNamed(String name);

    /**
     * Verifica se existe um cenario com o nome dado.
     *
     * @param scenery - Nome do Cenario.
     * @return true se existir um Cenario com esse nome;
     *         false se nao existir.
     */
    boolean isThereASiteNamed(String scenery);

    /**
     * Verifica se o tipo dado e valido.
     *
     * @param type - Nome do Tipo.
     * @return true se existe esse tipo;
     *         false se nao existir.
     */
    boolean isTypeValid(String type);

    /**
     * Verifica se existe uma zanga entre @param exBullyName e @param exVictimName.
     *
     * @param exBullyName - Nome da Vedeta.
     * @param exVictimName - Nome do Colaborador vitima.
     * @return true se existir zanga;
     *         false se nao existir.
     */
    boolean isThereAFightWith(String exBullyName, String exVictimName);

    /**
     * Verifica se existe um Vedeta com o nome dado.
     *
     * @param name - Nome da Vedeta.
     * @return true se existir um Vedeta com esse nome;
     *         false se nao existir.
     */
    boolean isThereAVedetteNamed(String name);

    /**
     * Verifica se a duracao da Gravacao e valida.
     *
     * @param duration - Duracao da Gravacao.
     * @return true se for > 0;
     *         false se for <= 0.
     */
    boolean isDurationValid(int duration);

    /**
     * Verifica se existe um Produtor com o nome dado.
     *
     * @param name - Nome da Produtor.
     * @return true se existir um Produtor com esse nome;
     *         false se nao existir.
     */
    boolean isThereAProducerNamed(String name);

    /**
     * Verifica se existe um Realizador com o nome dado.
     *
     * @param name - Nome da Realizador.
     * @return true se existir um Realizador com esse nome;
     *         false se nao existir.
     */
    boolean isThereADirectorNamed(String name);

    /**
     * Verifica se existe um Tecnico com o nome dado.
     *
     * @param name - Nome da Tecnico.
     * @return true se existir um Tecnico com esse nome;
     *         false se nao existir.
     */
    boolean isThereATechnicianNamed(String name);

    /**
     * Verifica se existem Colaboradores com os nomes guardados num vetor dado.
     *
     * @param names - Nomes dos Colaboradores guardados num vetor.
     * @param  numberOfStaffMembers - Numero de Nomes dentro do vetor.
     * @return true se existirem todos os Colaboradores com os nomes dados;
     *         false se nao existir pelo menos 1.
     */
    boolean isThereStaffMembersNamed(String[] names, int numberOfStaffMembers);

    /**
     * Verifica se existe zangas entre os Colaboradores com nomes guardados no vetor dado
     *
     * @param names - Nomes dos Colaboradores.
     * @return true se existir pelo menos uma zanga;
     *         false se existir nenhuma.
     */
    boolean isThereFightsBetweenThisStaff(String[] names);

    /**
     * Verifica se existe gravacoes que causam conflito seja de staff ou cenario num periodo de tempo
     * E nao seja possivel reagendar tais gravacoes.
     *
     * @param scenery - Nome do Cenario.
     * @param date - Data da Gravacao.
     * @param names - Nomes da Staff participante na gravacao.
     * @return true se existir conflito e nao seja possivel reagendar;
     *         false se nao existir conflito ou seja possivel reagendar.
     */
    boolean isThereDatesConflict(String scenery, int[] date, String[] names);

    /**
     * Verifica se e preciso reagendamento de gravacoes de acordo com uma gravacao.
     *
     * @param scenery - Nome do Cenario.
     * @param date - Data da Gravacao.
     * @param names - Nomes da staff participante na gravacao.
     * @return true se for preciso reagendamento;
     *         false se nao for preciso.
     */
    boolean isReschuleNeeded(String scenery, int[] date, String[] names);

    /**
     *Reagenda todas as gravacoes conflituosas.
     *
     * @param scenery - Nome do Cenario.
     * @param date - Data da Gravacao.
     * @param names - Nomes da Staff participante na gravacao.
     */
    void reschedule(String scenery, int[] date, String[] names);
}
