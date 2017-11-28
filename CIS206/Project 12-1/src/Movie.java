/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joshw
 */
public class Movie implements Comparable
{
    public String title;
    public String category;
    
    public Movie(String title, String category)
    {
        this.setTitle(title);
        this.setCategory(category);
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory( String category )
    {
        this.category = category;
    }
    
    @Override
    public String toString()
    {
        return this.getTitle();
    }
    
    @Override
    public int compareTo(Object o)
    {
        Movie m = (Movie) o;
        int titleCompare = this.getTitle().compareTo(m.getTitle());
        if (titleCompare != 0)
            return titleCompare;
        else
            return(this.getTitle().compareToIgnoreCase(m.getTitle()));
    }
}
