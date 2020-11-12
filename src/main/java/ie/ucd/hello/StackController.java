package ie.ucd.hello;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StackController {
    private Map<String, LinkedStack<String>> stacks = new HashMap<String, LinkedStack<String>>();
    private ArrayList<StackDescription> descriptions = new ArrayList<StackDescription>();

    @RequestMapping(value="/stack", method=RequestMethod.POST) //ok
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createStack(@RequestBody StackDescription description) {
        descriptions.add(description);
        stacks.put(description.getName(), new LinkedStack<String>());
    }

    @RequestMapping(value="/stack", method=RequestMethod.GET)   //ok
    public ArrayList<StackDescription> listQueues() {
        return descriptions;
    }

//-------------------------------------------------------------------------------


    @RequestMapping(value="/stack/{name}/size", method=RequestMethod.GET)
    public StackSize getSize(@PathVariable String name) {
        LinkedStack<String> stack = stacks.get(name);
        if (stack == null) throw new NoSuchStackException();
        return new StackSize(stack.size());
    }
//-------------------------------------------------------------------------------

    @RequestMapping(value="/stack/{name}", method=RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void push(@PathVariable String name, @RequestBody StackItem item) {
        LinkedStack<String> stack = stacks.get(name);
        if (stack == null) throw new NoSuchStackException();
        stack.push(item.getItem());
    }

    
    @RequestMapping(value="/stack/{name}", method=RequestMethod.GET) 
    public StackItem top(@PathVariable String name) {
        LinkedStack<String> stack = stacks.get(name);
        if (stack == null) throw new NoSuchStackException();
        return new StackItem(stack.top());
    }

    @RequestMapping(value="/stack/{name}", method=RequestMethod.DELETE)
    public StackItem pop(@PathVariable String name) {
        LinkedStack<String> stack = stacks.get(name);
        if (stack == null) throw new NoSuchStackException();
        return new StackItem(stack.pop());
    }
    
 
}