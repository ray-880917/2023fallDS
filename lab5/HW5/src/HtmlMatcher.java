import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Stack;

public class HtmlMatcher
{
	private String urlStr;
	private String content;

	public HtmlMatcher(String urlStr)
	{
		this.urlStr = urlStr;
	}

	private String fetchContent() throws IOException
	{
		URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String retVal = "";

		String line = null;
		while ((line = br.readLine()) != null)
		{
			retVal = retVal + line + "\n";
		}

		return retVal;
	}

	public void match() throws IOException
	{
		if (content == null)
		{
			content = fetchContent();
		}

		/* Create a stack to store the tag */
		Stack<String> tagStack = new Stack<>();

		int indexOfOpen = 0;

		while ((indexOfOpen = content.indexOf("<", indexOfOpen)) != -1)
		{
			// Get full tag. e.g. "<div id="abcdefg">","</a>","</div>"...
			int indexOfClose = content.indexOf(">", indexOfOpen);
			String fullTag = content.substring(indexOfOpen + 1, indexOfClose);

			
			// Extract tag name from fullTag. e.g. "div","/a","/div"...
			String tagName = null;
			int indexOfSpace = -1;
			if ((indexOfSpace = fullTag.indexOf(" ")) == -1)
			{
				// If there is no space in the fullTag (e.g. "<li>","</a>","</div>")
				// then the tag name will be the words between first and last character.
				// For example, if fullTag is "<li>" then the tagName will be "li";
				// For example, if fullTag is "</li>" then the tagName will be "/li" (Note that
				// we preserve the slash'/' so we can tell that this is a close tag in the
				// future)
				
				// YOUR TURN
				//1. Get the tagName from no space in the fullTag
				
				//tagName = 

			}
			else
			{
				// If there are some space in the fullTag 
				// (e.g "<li id='theID'>","<a href='http://www.google.com.tw/'>")
				// then the tag name will be the words between first character and the first
				// space.
				// For example, if fullTag is "<li id='theID'>" the tagName will be "li";
				// For example, if fullTag is "<a href='http://www.google.com.tw/'>" the tagName
				// will be "a"
				
				// YOUR TURN
				//2. Get the tagName from some space in the fullTag  
				
				//tagName = 

			}
			
			//You can ignore the tag like these two.
			if (tagName.toLowerCase().equals("meta") || tagName.toLowerCase().equals("!doctype"))
			{
				indexOfOpen = indexOfClose;
				continue;
			}

			// Determine whether this tag is an open tag 
			// (e.g. "<div>") or close tag (e.g."</div>")
			int indexOfSlash = -1;
			if ((indexOfSlash = tagName.indexOf("/")) == -1)
			{
				// This is an open tag, so simply 'push' it into stack
				// YOUR TURN
				// 3. If it is an open tag, then push

			}
			else
			{
				// This is an close tag, so we should compare it to the topmost tag in the stack
				// Remove the slash '/' (the first character of tagName), so that we can compare
				// it with the open tag name in stack
				
				// YOUR TURN
				// 4. If it is an close tag, then remove slash '/'
				
				//tagName = 

				// But...what if there is no topmost tag in the stack
				if (tagStack.isEmpty())
				{
					// stack is empty, this tag is an invalid tag
					System.out.println("False");
					return;
				}
				
				
				
				// YOUR TURN
				// 5. Compare and pop
				// You should get the top tag of the stack.
				// If the tagName is equal to the top tag in the stack,
				// 'Pop' out it.
				// Otherwise, we find that this tag is an invalid tag
				
				//String topMostTag = 
				if (topMostTag.equals(tagName))
				{
					

				}
				else
				{
					System.out.println("False " + getStackString(tagStack));
					return;
				}
			}
			// Move the searching start point, 
			// so that we can search the next tag in htmlContent
			indexOfOpen = indexOfClose;
		}

		// After search and compare all the tag in the htmlContent,
		// We should also check whether the stack is empty or not.
		if (!tagStack.isEmpty())
		{
			// The stack is not empty, this mean the tags is invalid
			System.out.println("False " + getStackString(tagStack));
		}
		else
		{
			// The stack is empty, all tags successfully matched.
			System.out.println("True");
		}
	}

	// A function that will print the stack for you to debug.
	private String getStackString(Stack<String> stack)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stack.size(); i++)
		{
			if (i > 0)
			{
				sb.append(" ");
			}
			sb.append(stack.get(i));
		}
		return sb.toString();
	}
	
}
