import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class Employee  {
	
	@Autowired
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}                            

/*	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("initialise");
		
	}*/
	public void init()
	{
		System.out.println("From init");
	}
	
	public void destroy()
	{
		System.out.println("From destroy");
	}

	
	
}
