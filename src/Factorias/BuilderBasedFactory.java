package Factorias;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class BuilderBasedFactory<T> implements Factory<T> {
	private Map<String, Builder<T>> _builders;
	private List<JSONObject> _builders_info;

	public BuilderBasedFactory() {
		_builders = new HashMap<String, Builder<T>>();
		_builders_info = new LinkedList<JSONObject>();
		// Create a HashMap for _builders, and a LinkedList _builders_info
		// …
	}

	public BuilderBasedFactory(List<Builder<T>> builders) {
		this();
		for (Builder<T> b : builders) {
			add_builder(b);
		}
		// call add_builder(b) for each builder b in builder
		// …
	}

	public void add_builder(Builder<T> b) {
		_builders.put(b.get_type_tag(), b);
		_builders_info.add(b.get_info());
		// add an entry “b.getTag() |−> b” to _builders.
		// ...
		// add b.get_info() to _buildersInfo
		// ...
	}

	@Override
	public T create_instance(JSONObject info) throws JSONException, Exception {
		if (info == null) {
			throw new IllegalArgumentException("’info’ cannot be null");
		}
		T result = null;
		Builder<T> b = _builders.get(info.getString("type"));
		if (b != null)
			result = b.create_instance(info.has("data") ? info.getJSONObject("data") : new JSONObject());
		if (result != null)
			return result;
		// Look for a builder with a tag equals to info.getString("type"), in the
		// map _builder, and call its create_instance method and return the result
		// if it is not null. The value you pass to create_instance is the following
		// because ‘data’ is optional:
		//
		// info.has("data") ? info.getJSONObject("data") : new getJSONObject()
		// …
		// If no builder is found or the result is null ...
		throw new IllegalArgumentException("Unrecognized ‘info’:" + info.toString());
	}

	@Override
	public List<JSONObject> get_info() {
		return Collections.unmodifiableList(_builders_info);
	}
}
