import java.io.IOException;
import java.util.ArrayList;

public class WebPage
{
	public String url;
	public String name;
	public WordCounter counter;
	public double score;

	public WebPage(String url, String name)
	{
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);
	}

	public void setScore(ArrayList<Keyword> keywords) throws IOException
	{
		score = 0;
//		1. calculate score
		System.out.println("website's name: " + this.name + ", keyword:");
		for (Keyword k : keywords)
		{
			int count=counter.countKeyword(k.name);
			System.out.println(k.name+" weight: "+k.weight+" count: "+count);
			score += count * k.weight;
		}
		System.out.println("score: "+score);
	}
}