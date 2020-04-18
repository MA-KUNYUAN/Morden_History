package com.example.mordenhistory.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mordenhistory.Question;
import com.example.mordenhistory.QuizContract;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelp extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ModernHistory.db";

    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    //when creating instance of DatabaseHelp we only have to use context

    public DatabaseHelp(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //this Oncreate method will be called the first time we try and access this database

    @Override
    public void onCreate(SQLiteDatabase db) {
        //save the database reference , will use this value after the creation of the database to add some values

        this.db = db;

        //create database table
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_TOPIC + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    //oncreate will only be called the first time we try and access the database
    //otherwise it would not be called again unless we delete the app from our phone
    //if we want to add additional column to our table the onUpgrade method will be called
    //it will drop the existing table and create a new one
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    //provide the data for our table
    private void fillQuestionsTable() {
        Question q1 = new Question("What era most inspired people in the Enlightenment to apply reason to society and government?","Enlightenment", "The Protestant Reformation", "The Age of Exploration", "The Scientific Revolution", 3);
        addQuestion(q1);
        Question q2 = new Question(" We call this era the Age of Reason because people began to apply __________ to society and government.","Enlightenment", "Logic", "Tyranny", "Tradition", 1);
        addQuestion(q2);
        Question q3 = new Question("John Locke believed the government should protect the life, liberty, and property of its citizens. We call these things:", "Enlightenment", "Natural Rights", "Reason", "Right to Rebel", 1);
        addQuestion(q3);
        Question q4 = new Question("When the government agrees to protect natural rights and citizens agree to abide by the laws and respect their leaders, they have a:","Enlightenment", "Separation of Church and State", "Social Contract", "Right to Rebel", 2);
        addQuestion(q4);
        Question q5 = new Question(" Citizens have a right to rebel if the government:","Enlightenment", "Raises taxes", "Gets a new leader you don't like", "Breaks the Social Contract", 2);
        addQuestion(q5);
        Question q6 = new Question("Which Enlightenment idea ensures no one leader has too much authority?","Enlightenment", "Separation of Church and State", "Divine Right", "Separation of Powers", 3);
        addQuestion(q6);
        Question q7 = new Question(" Many Kings before and during the Enlightenment believed that they were given the right to rule from God. This idea is called:","Enlightenment", "Natural Right to rule", "Unlimited Power", "Divine Right", 3);
        addQuestion(q7);
        Question q8 = new Question("Kings and Queens who tried to apply the ideas of the Enlightenment are called:", "Enlightenment", "Enlightened Despots", "Absolute Monarchs", "Constitutional Monarchs", 1);
        addQuestion(q8);
        Question q9 = new Question("The idea of Laissez-faire most closely fits with which type of economic system?","Enlightenment", "Traditional Economy", "Mixed Economy", "Free Market Economy", 3);
        addQuestion(q9);
        Question q10 = new Question("The writers during the Enlightenment, who popularized the new ideas of the era, are called:","Enlightenment", "Economists", "Philosophes", "Enlightened Despots", 2);
        addQuestion(q10);
        Question q11 = new Question("Which Enlightenment thinker produced plays and poems, as well as historical and philosophical essays?","Enlightenment", "Immanuel Kant", "Voltaire", "spread Enlightenment ideas as widely as possible", 3);
        addQuestion(q11);
        Question q12 = new Question("The Encyclopedie was published to","Enlightenment", "propose a new plan of government for France ", "inspire peasants to rise up against the ruling class", "inspire people to become more religious", 2);
        addQuestion(q12);
        Question q13 = new Question("The concept of individualism was most central to the political ideas of", "Enlightenment", "Thomas Hobbes", "Immanuel Kant", "John Locke", 3);
        addQuestion(q13);
        Question q14 = new Question("A common theme among Enlightenment thinkers was","Enlightenment", " a desire to improve society", "faith in traditional religious beliefs", "support for democratic forms of government", 1);
        addQuestion(q14);
        Question q15 = new Question("What did Thomas Hobbes believe?","Enlightenment", "Humans are all so kind and wonderful", "Humans were naturally cruel, selfish, and greedy", "Humans should go to church every day", 2);
        addQuestion(q15);


        Question q16 = new Question("Where did the British choose to focus their fighting in the late 1770s?","American Revolution", "The North", "The South", "The East", 2);
        addQuestion(q16);
        Question q17 = new Question(" The last MAJOR battle of the American Revolution was the __________.","American Revolution", "Battle of Bunker Hill", "Battle of Yorktown", "Battle of Trenton", 2);
        addQuestion(q17);
        Question q18 = new Question("What did the First Continental Congress want to avoid?", "American Revolution", "Native American Attacks", "Taxes", "War", 3);
        addQuestion(q18);
        Question q19 = new Question("What is considered the first battle of the American Revolution?","American Revolution", "Lexington and Concord", "Bunker Hill", "Trenton", 1);
        addQuestion(q19);
        Question q20 = new Question(" Who was the main author of the Declaration of Independence?","American Revolution", "Thomas Jefferson", "Ben Franklin", "George Washington", 1);
        addQuestion(q20);
        Question q21 = new Question("What were American's called who supported independence?","American Revolution", "Separatists", "Loyalists", "Patriots", 3);
        addQuestion(q21);
        Question q22 = new Question("Colonists who chose to side with the British were known as","American Revolution", "Neutrals", "Redcoats", "Loyalists", 3);
        addQuestion(q22);
        Question q23 = new Question("Why did many slaves choose to help the British?", "American Revolution", "they were offered food", "they were offered freedom", "Patriots would not pay them", 2);
        addQuestion(q23);
        Question q24 = new Question(" Most Loyalists were located in the ______","American Revolution", "West", "North", "South", 3);
        addQuestion(q24);
        Question q25 = new Question("What was the Hessians main goal for fighting?","American Revolution", "Money", "to Travel", "Fame", 1);
        addQuestion(q25);
        Question q26 = new Question("This treaty formally ended the American Revolution","American Revolution", "Treaty of Ghent", "Treaty of Paris of 1763", "Treaty of Paris of 1783", 3);
        addQuestion(q26);
        Question q27 = new Question("Which statement expresses an opinion about the causes of the Revolutionary War?","American Revolution", "Colonists participated in triangular trade.", "Samuel Adams founded the Sons of Liberty.", "The Quartering Act was a serious violation of the colonists’ liberties.", 3);
        addQuestion(q27);
        Question q28 = new Question(" The Battle of Saratoga was significant in the Revolutionary War because it", "American Revolution", "ended the British threat to the South", "convinced the French to support the Americans", "forced the British to withdraw from North America", 2);
        addQuestion(q28);
        Question q29 = new Question("Where was the first battle of the American Revolution fought?","American Revolution", "Valley Forge", "Lexington and Concord", "Yorktown", 2);
        addQuestion(q29);
        Question q30 = new Question("During the Revolutionary War, the most common way American women helped the Patriot cause was by","American Revolution", "acting as spies", "managing farms", "serving the military", 1);
        addQuestion(q30);




        Question q31 = new Question("France was deep in debt because?","French Revolution", "the queen's lavish spending", "money spent on the American Revolution", "all of the above", 3);
        addQuestion(q31);
        Question q32 = new Question("The idea that reason should guide society rather than tradition helped cause the revolution and came from","French Revolution", "the Declaration of Independence", "the Enlightenment", "the Scientific Revolution", 2);
        addQuestion(q32);
        Question q33 = new Question("Most of the people of France belonged to the ","French Revolution", "3rd Estate", "2nd Estate", "1st Estate", 1);
        addQuestion(q33);
        Question q34 = new Question("Why was voting in the Estates General unfair","French Revolution", "each estate voted by how many members there were", "each estate got the same number of votes", "the King got two votes", 2);
        addQuestion(q34);
        Question q35 = new Question(" When the people of Paris heard that the military was going to stop the revolution their response was to ", "French Revolution", "storm Bastille", "leave the city", "force the king to come to Paris", 1);
        addQuestion(q35);
        Question q36 = new Question("The National Assembly set down the ideas of the Revolution in ","French Revolution", "the Declaration of Independence", "the Declaration of the Rights of Man", "the US Constitution", 2);
        addQuestion(q36);
        Question q37 = new Question("During the Reign of Terror, who was safe from the Guillotine?","French Revolution", "the nobility", "known revolutionaries", "no one", 3);
        addQuestion(q37);
        Question q38 = new Question("French King who was executed during the Revolution","French Revolution", "Klemens von Metternich", "Maximillien Robespierre", "Louis XVI", 3);
        addQuestion(q38);
        Question q39 = new Question("The Declaration of the Rights of Man and The Citizen proclaimed:","French Revolution", "Equal rights for all men, but no political rights for women", "an end to the monarchy", "equal rights for all citizens and political rights for women", 1);
        addQuestion(q39);
        Question q40 = new Question(" What is the significance of the Tennis Court Oath?", "French Revolution", "it led to a new constitution for France", "it started the French Revolution", "it was the beginning of the Reign of Terror", 1);
        addQuestion(q40);
        Question q41 = new Question("How did the Enlightenment and the American Revolution influence the French Revolution?","French Revolution", "the people of France overthrew their absolute monarchy", "absolute monarchy was strengthened", "France was divided into three estates", 1);
        addQuestion(q41);
        Question q42 = new Question("The Second Estate was composed of ","French Revolution", "Church leaders", "Peasants", "Nobility", 3);
        addQuestion(q42);


        Question q43 = new Question("Rapid movement of people from the rural areas to cities in search of industrial jobs was known as:","Industrial Revolution", "Industrialization", "Urbanization", "Migration", 2);
        addQuestion(q43);
        Question q44 = new Question(" Which of the following was NOT associated with early factory working conditions?","Industrial Revolution", "Low wages", "Widespread pollution", "Safe working conditions", 2);
        addQuestion(q44);
        Question q45 = new Question("The Industrial Revolution was triggered by sweeping changes in what?","Industrial Revolution", "Religion", "Education", "Farming/Agriculture", 3);
        addQuestion(q45);
        Question q46 = new Question("At first, Factories were built on rivers. Why is this so?","Industrial Revolution", "To take baths", "Clean equipment", "For power", 3);
        addQuestion(q46);
        Question q47 = new Question("The industrial development in Europe had the GREATEST impact on what? ?", "Industrial Revolution", "Farming", "Environment", "Politics", 2);
        addQuestion(q47);
        Question q48 = new Question("The spread of the Industrial Revolution brought many far-reaching changes to the world.  One of these changes was _____. ","Industrial Revolution", "Growth of Industrial Capitalism", "Rise of Farming", "End of Trade Unions", 1);
        addQuestion(q48);
        Question q49 = new Question("Which BEST describes the labor situation in Europe during the early stages of the industrial revolution? ","Industrial Revolution", "agricultural laborers were needed", "machines replaced human labor", "Fewer Urban workers needed", 2);
        addQuestion(q49);
        Question q50 = new Question("Why did the Industrial Revolution begin in England? ","Industrial Revolution", "famine in Europe", "war in Europe", "natural resources ", 3);
        addQuestion(q50);
        Question q51 = new Question(" _________ is a group of workers that work together to improve pay, work hours, and benefits.","Industrial Revolution", "Labor Unions.", "Reformers", "Urbanization", 1);
        addQuestion(q51);
        Question q52 = new Question("What impact did the Agricultural Revolution have on the population of England?", "Industrial Revolution", "The population increased a little.", "The population declined steeply.", "The population increased dramatically", 3);
        addQuestion(q52);
        Question q53 = new Question("What was the use of machine-made parts that are exactly alike made it easier to fit parts together and fix them when broken?","Industrial Revolution", "assembly line", "interchangeable parts", "mass production", 2);
        addQuestion(q53);
        Question q54 = new Question("Unsafe and unsanitary homes, especially in overcrowded cities","Industrial Revolution", "tenement housing", "city life", "rural areas" , 1);
        addQuestion(q54);


        Question q55 = new Question("The main cause of the ______ was Russia´s desire to gain land on the Black Sea from the Ottoman Empire to establish a warm weather port.","The age of Imperialism", "Boer War", "Crimean War", "Sepoy Mutiny" , 2);
        addQuestion(q55);
        Question q56 = new Question("How did Menelik II keep colonial interest out of Ethiopia?","The age of Imperialism", "He exploited European rivalries and built a modern army.", "He signed a pact with Egypt and Algeria to fight against invaders", "He signed peace treaties with Britain, France and Italy.", 1);
        addQuestion(q56);
        Question q57 = new Question(" In the 1800´s the Zulu chief ______ used highly disciplined warriors and good military organization to create a large state in southern Africa.","The age of Imperialism", "Menelik II", "Shaka" , "Raj", 2);
        addQuestion(q57);
        Question q58 = new Question("The opposition of Dutch settlers to British policy in South Africa turned violent during the _______.","The age of Imperialism", "Boer War", "Sepoy Mutiny", "Berlin Conference", 1);
        addQuestion(q58);
        Question q59 = new Question("Where did the British Empire control an entire continent?", "The age of Imperialism", "North America", "Africa", "Australia", 3);
        addQuestion(q59);
        Question q60 = new Question("Why was India called the \"jewel in the crown\"?","The age of Imperialism", "It was the most valuable of all of Britain´s colonies.", "It had a vast supply of diamond, rubies and sapphires.", "The sepoys were a perfect model of successful Imperialism.", 1);
        addQuestion(q60);
        Question q61 = new Question("What happened as a result of the Berlin Conference of 1884-1885??","The age of Imperialism", "France and Britain agreed to govern their African colonies jointly.", "There was less fighting between African leaders and European powers.", "European powers divided Africa into colonies without consulting African leaders.", 3);
        addQuestion(q61);
        Question q63 = new Question("What caused low food supplies in Africa during European colonization?","The age of Imperialism", "Most of the farm land was used for mining.", "Europeans used too much of the farmland as building sites.", "Europeans insisted on the growth of cash crops, instead of food crops.", 3);
        addQuestion(q63);
        Question q64 = new Question("The Suez Canal was built through the combined efforts of the","The age of Imperialism", "French and British", "French and Egyptians", "Russians and Persians.", 2);
        addQuestion(q64);
        Question q65 = new Question(" The sepoys were", "The age of Imperialism", "Indian soldiers", "Bengal Hindus", "Mughal princes", 1);
        addQuestion(q65);
        Question q66 = new Question("Before the invention of the steamboat European exploration of Africa had been impossible due to...","The age of Imperialism", "Strong African armies managed to keep Europeans out", "Existing diseases in Africa discouraged European exploration", "All of the above", 3);
        addQuestion(q66);
        Question q67 = new Question("Superior weapons of imperialists made the fights between Africans and European powers unfair.","The age of Imperialism", "False.- the fights were always fair", "True.- Most African resistance was unsuccessful", "False.- Africans had superior weapons", 2);
        addQuestion(q67);





    }

    //insert the data in our database
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_TOPIC, question.getTopic());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv);
    }

    //get Questions from database
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        //cursor to query our database
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setTopic(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_TOPIC)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
