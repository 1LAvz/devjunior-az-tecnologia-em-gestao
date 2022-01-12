import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FinanceiroPU");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        //FIND
/*        Pessoa2 cliente = entityManager.find(Pessoa2.class, 1);
        System.out.println("Nome do cliente: " + cliente.getNome());*/

        //INSERT
/*      Pessoa2 cliente = new Pessoa2();
        cliente.setNome("John Doe");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();*/

        //DELETE
/*        Pessoa2 cliente = entityManager.find(Pessoa2.class, 1);
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();*/

        //MODIFY
/*        Pessoa2 cliente = new Pessoa2();
        cliente.setId(2);
        cliente.setNome("Mayara Santana Zanella");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();*/

        entityManager.close();
        entityManagerFactory.close();

//        System.out.println(TipoLancamento2.DESPESA.getDescricao());


    }

  /*  enum TipoLancamento2 {

        RECEITA("Receita"), DESPESA("Despesa");

        private String descricao;

        TipoLancamento2(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

    }*/
}
