# Veeva
Brief description
I dynamically automate a happy path scenario to show the flow. 
I created it from scratch in Cucumber. First, I made it go to the URL in the hooks before method. 
I got the URL from configuration.properties. With the After method, I made it take a screenshot when the scenario failed. 
Then I created a feature file where I worked on a happy path scenario and used a scenario outline. 
I created my Runner class to receive HTML reports and implemented the feature file in the step definition.
To receive Expected data; dynamically, I created a POJO class with the required variables.
And in the calculateLogic class, I wrote a calorie calculation code in line with the information I got from the site. 
You can also find the code I calculated in grams. I aim to automate the web table entirely dynamically.
