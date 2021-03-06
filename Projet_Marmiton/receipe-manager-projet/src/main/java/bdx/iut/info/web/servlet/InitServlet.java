package bdx.iut.info.web.servlet;

import bdx.iut.info.persistence.dao.IngredientDao;
import bdx.iut.info.persistence.dao.ReceipeDao;
import bdx.iut.info.persistence.domain.Ingredient;
import bdx.iut.info.persistence.domain.Step;
import bdx.iut.info.persistence.domain.Receipe;
import bdx.iut.info.persistence.domain.UnitType;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**.
 * Simple servlet which fills the database with dummy stuffs
 */
@Singleton
public class
InitServlet extends HttpServlet {
    /**
     *
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(InitServlet.class);
    /**
     *
     */
    @Inject
    private IngredientDao ingredientDao;
    /**
     *
     */
    @Inject
    private ReceipeDao receipeDao;

    /**.
     * HTTP GET access
     * @param req use an optional nb parameter to make evidence
     *           of transactionnal behavior volontary triggering an exception .
     * @param resp response to sent .
     * @throws ServletException by container
     * @throws IOException by container
     */
    @Override
    protected void doGet(final HttpServletRequest req,
                         final HttpServletResponse resp)
            throws ServletException, IOException {

        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ArrayList<Step> steps = new ArrayList<Step>();

        Ingredient farine = new Ingredient();
        farine.setName("Farine");
        farine.setUnitType(UnitType.weight);
        ingredients.add(farine);

        Ingredient oeuf = new Ingredient();
        oeuf.setName("Oeuf");
        oeuf.setUnitType(UnitType.number);
        ingredients.add(oeuf);

        Ingredient sucre = new Ingredient();
        sucre.setName("Sucre");
        sucre.setUnitType(UnitType.weight);
        ingredients.add(sucre);

        Ingredient huile = new Ingredient();
        huile.setName("Huile");
        huile.setUnitType(UnitType.volume);
        ingredients.add(huile);

        Ingredient beurreFondu = new Ingredient();
        beurreFondu.setName("Beurre fondu");
        beurreFondu.setUnitType(UnitType.weight);
        ingredients.add(beurreFondu);

        Ingredient lait = new Ingredient();
        lait.setName("Lait");
        lait.setUnitType(UnitType.volume);
        ingredients.add(lait);

        Ingredient rhum = new Ingredient();
        rhum.setName("Rhum");
        rhum.setUnitType(UnitType.volume);
        ingredients.add(rhum);


        Step step1 = new Step();
        step1.setStepText("Mettre la farine dans une "
                +
                "terrine et former un puits.");
        steps.add(step1);

        Step step2 = new Step();
        step2.setStepText("Y déposer les oeufs entiers,"
                +
                " le sucre, l'huile et le beurre.");
        steps.add(step2);

        Step step3 = new Step();
        step3.setStepText("Mélanger délicatement avec un fouet"
                +
                " en ajoutant au fur et à mesure le lait."
                +
                " La pâte ainsi obtenue doit avoir une consistance d'un "
                +
                "liquide légèrement épais.");
        steps.add(step3);


        Step step4 = new Step();
        step4.setStepText("Parfumer de rhum.");
        steps.add(step4);


        Step step5 = new Step();
        step5.setStepText("Faire chauffer une poêle antiadhésive "
                +
                "et la huiler très légèrement. Y verser une louche de pâte,"
                +
                " la répartir dans la poêle puis attendre qu'elle soit cuite "
                +
                "d'un côté avant de la retourner. Cuire ainsi toutes les crêpes"
                +
                " à feu doux.");
        steps.add(step5);

        final int cookTime = 20;
        final int prepareTime = 10;
        final int qteFarine = 300;
        final int qteOeuf = 3;
        final int qteSucre = 3;
        final int qteHuile = 2;
        final int qteBeurre = 50;
        final int qteLait = 75;
        final int qteRhum = 5;
        final Receipe receipe = new Receipe();
        receipe.setTitle("Crèpes");
        receipe.setCookTime(cookTime);
        receipe.setPreparationTime(prepareTime);
        receipe.addIngredient(farine, qteFarine, "g");
        receipe.addIngredient(oeuf, qteOeuf, "");
        receipe.addIngredient(sucre, qteSucre, "cuil. soupe");
        receipe.addIngredient(huile, qteHuile, "cuil. soupe");
        receipe.addIngredient(beurreFondu, qteBeurre, "g");
        receipe.addIngredient(lait, qteLait, "cl");
        receipe.addIngredient(rhum, qteRhum, "cl");
        receipe.addInstruction(step1);
        receipe.addInstruction(step2);
        receipe.addInstruction(step3);
        receipe.addInstruction(step4);
        receipe.addInstruction(step5);

        LOGGER.info("Will add " + ingredients.size() + " ingredients");
        for (Ingredient ingredient: ingredients) {
            resp.getOutputStream().print(
                    "<p> Add" + ingredient.getName() + "</p>"
            );
            LOGGER.info("Will add " + ingredient.getName());
            ingredientDao.create(ingredient);
        }


        resp.getOutputStream().print("List of ingredients</br>");
        for (Ingredient ingredient: ingredientDao.findAll()) {
            resp.getOutputStream().print(
                    ingredient.getName() + " / " + ingredient.getUnitType()
            );
        }

/*
        resp.getOutputStream().print("Add instructions </br>");
        for(Step step : steps) {
            resp.getOutputStream().print(
            "<p> Add" + step.getStepText() + "</p>"
            );
            instructionDao.create(step);
        }
*/
        receipeDao.create(receipe);


        resp.getOutputStream().print("<h1>Listing des recettes</h1>");
        for (Receipe receipe1: receipeDao.findAll()) {
            resp.getOutputStream().println(receipe1.toString());
        }


        resp.getOutputStream().print("done");
    }
}
