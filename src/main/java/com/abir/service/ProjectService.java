package com.abir.service;
import com.abir.model.Project;


import java.util.Arrays;
import java.util.List;
public class ProjectService {
	List<Project> projects;
	public ProjectService()
	{
		this.projects = Arrays.asList(
				new Project("Android app","Android app for BCS preparation based on MCQ questions.",Arrays.asList("JAVA"),Arrays.asList("Android Studio")),
				new Project("Endless runner game","A short 3d game 'Block runner'. Designed and completed 3 levels.",Arrays.asList("C#"),Arrays.asList("Unity3d","Visual Studio")),
				new Project("Karnaugh map producer","A Program producing Karnaugh map for Synchronous counter in digital circuit design.",Arrays.asList("C++"),Arrays.asList("Codeblocks")),
				new Project("Object Detection using machine learning","Brain tumor detection Using Principal Component Analysis and Adaptive Neuro Fuzzy Inference System from MRI images of brain.",Arrays.asList("Python"),Arrays.asList("Google Colab"))
				);
	}
	public List<Project> getProjects()
	{
		return this.projects;
	}
}
