package The_Producers;

import Staff.StaffMember;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Representa uma Gravacao.
 */
interface Recording {

    //Constantes
    DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("yyyy M d");

    /**
     * Devolve o custo associado a gravacao.
     *
     * @return  totalCost
     */
    int getCost();

    /**
     * Devolve a mensangem generica para ser usada em varios metodos de acordo com um formato.
     *
     * @return msg (Formato) -(AAAA MM DD; Nome_Do_Produtor; Nome_Do_Realizador.[; Suspensa!] - caso esteja suspensa.).
     */
    String toStringExtra();

    /**
     * Devovle o nome do cenario da gravacao.
     *
     * @return scenery.getName().
     */
    String getScenery();

    /**
     * Altera o estado da gravacao de true para false e vice-versa(Suspended)
     */
    void changeStatus();

    /**
     * Verifica se a gravacao tem um colaborador com o nome dado.
     *
     * @param name - Nome do colaborador.
     * @return true se pertencer ao "staff";
     *         false se nao pertencer ao "staff".
     */
    boolean hasStaffMemberNamed(String name);

    /**
     * Devolve se a gravacao esta suspensa ou nao.
     * @return true se estiver suspensa;
     *         false se nao estiver suspensa.
     */
    boolean isSuspended();

    /**
     * Verifica se existe ainda zangas entre colaboradores na gravacao que possam ainda suspender a gravacao
     *
     * @return true se houver zangas.
     *         false se nao houver zangas
     */
    boolean isRecordingSaved();

    /**
     * Devolve a data de inicio da gravacao.
     *
     * @return start.
     */
    LocalDateTime getStartingDate();

    /**
     * Devolve a data de fim da gravacao.
     *
     * @return start.plusMinutes(duration).
     */
    LocalDateTime getEndDate();

    /**
     * Devolve o produtor da gravacao.
     *
     * @return staff.next().
     */
    StaffMember getProducer();

    /**
     * Devolve a duracao da gravacao.
     *
     * @return duration
     */
    int getDuration();

    /**
     * Devolve um vetor de nomes dos colaboradores da gravacao.
     *
     * @return staffArray.
     */
    String[] getStaff();

    /**
     * Altera a data de inicio (e por consequencia do fim) da gravacao para a data dada.
     *
     * @param tempStartDate -  Nova data de Inicio.
     */
    void changeDate(LocalDateTime tempStartDate);
}
